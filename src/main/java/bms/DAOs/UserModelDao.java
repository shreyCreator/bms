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
        String FETCH_USER_EMAIL = "Select \"email\",\"password\",\"first_name\",\"last_name\",\"address\",\"phone_no\" from \"user_model\" WHERE \"email\" ilike ?";
        PreparedStatement stmt = con.prepareStatement(FETCH_USER_EMAIL);

        stmt.setString(1, email.trim().toLowerCase());

        ResultSet rst = stmt.executeQuery();
        boolean doesUserExist = rst.next();
        if (doesUserExist) {
            rst.next();
            return rst;
        }
        return rst;

    }

    public ResultSet getUserByEmail(String email) throws SQLException {
        Connection con = getPostgreConnection();
        String FETCH_USER_EMAIL = "Select \"email\",\"password\" from \"user_table\" WHERE \"email\" ilike ?";
        PreparedStatement stmt = con.prepareStatement(FETCH_USER_EMAIL);

        stmt.setString(1, email.trim().toLowerCase());

        ResultSet rst = stmt.executeQuery();
        return rst;

    }

    public String getUserPassword(String email) {

        try (ResultSet user = getUserByEmail(email)) {
            if (user.next()) {

                return user.getString("password");
            }
            throw new UserExistException("user does not exist");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    public void saveUser(UserModel user) throws SQLException {
        Connection con = getPostgreConnection();
        ResultSet rst = getUserByEmail(user.getEmail());
        if (rst.next()) {
            throw new UserExistException("user exist");
        }
        String hashedPass = encodePassword(user.getPassword());
        String INSERT_USER = "INSERT INTO \"user_table\" (\"email\",  \"address\",\"password\") VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(INSERT_USER);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getAddress());
        stmt.setString(3, hashedPass);
        int row = stmt.executeUpdate();
        con.close();
    }

    String encodePassword(String password) {
        password = Base64.getEncoder()
                .encodeToString(password.getBytes(StandardCharsets.UTF_8));
        return password;
    }

}
