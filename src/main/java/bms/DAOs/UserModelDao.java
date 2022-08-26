package bms.DAOs;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import bms.config.PropertiesConfiguration;
import bms.exceptions.UserExistException;
import bms.models.UserModel;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserModelDao {
    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getPostgreConnection() throws SQLException {
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionUrl(),
                propertiesConfiguration.getDbUsername(),
                propertiesConfiguration.getDbPassword());
    }

    public ResultSet getUser(String email) throws SQLException {
        Connection con = getPostgreConnection();
        String FETCH_USER_EMAIL = "Select \"email\",\"password\",\"address\" from \"user_table\" WHERE \"email\" ilike ?";
        PreparedStatement stmt = con.prepareStatement(FETCH_USER_EMAIL);

        stmt.setString(1, email.trim().toLowerCase());

        ResultSet rst = stmt.executeQuery();
        boolean doesUserExist = rst.next();
        System.out.println(doesUserExist);
        if (doesUserExist) {
            return rst;
        }
        rst.close();
        return rst;

    }

    public String getUserPassword(String email) {

        try (ResultSet rst = getUser(email)) {
            if (rst.isClosed()) {

                throw new UserExistException("Invalid credentials");
            }

            return rst.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    public void saveUser(UserModel user) throws SQLException {
        Connection con = getPostgreConnection();
        doesUserExist(user);
        String hashedPass = encodePassword(user.getPassword());
        String INSERT_USER = "INSERT INTO \"user_table\" (\"email\",  \"address\",\"password\") VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(INSERT_USER);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getAddress());
        stmt.setString(3, hashedPass);
        int row = stmt.executeUpdate();
        stmt.close();
        con.close();
    }

    private void doesUserExist(UserModel user) throws SQLException {
        ResultSet rst = getUser(user.getEmail());
        if (!rst.isClosed()) {
            throw new UserExistException("user exist");
        }
    }

    String encodePassword(String password) {
        password = Base64.getEncoder()
                .encodeToString(password.getBytes(StandardCharsets.UTF_8));
        return password;
    }

}
