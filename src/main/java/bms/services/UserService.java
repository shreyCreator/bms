package bms.services;

import bms.DAOs.MovieDao;
import bms.DAOs.UserModelDao;
import bms.Validators.EmailValidator;
import bms.exceptions.UserExistException;
import bms.models.UserModel;
import jakarta.inject.Inject;

public class UserService {

    @Inject
    UserModelDao userModelDao;
    @Inject
    EmailValidator emailValidator;

    public String saveUser(UserModel user) throws Exception {

        if (emailValidator.isEmailValid(user.getEmail())) {
            userModelDao.saveUser(user);
        } else {
            return "incorrect email";
        }

        return "saved";
    }

}
