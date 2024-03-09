package com.cyngofokglobal.springsecurityclient.service;

import com.cyngofokglobal.springsecurityclient.entity.User;
import com.cyngofokglobal.springsecurityclient.entity.VerificationToken;
import com.cyngofokglobal.springsecurityclient.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
