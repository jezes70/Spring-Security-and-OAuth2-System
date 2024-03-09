package com.cyngofokglobal.springsecurityclient.event.listener;

import com.cyngofokglobal.springsecurityclient.entity.User;
import com.cyngofokglobal.springsecurityclient.event.RegistrationCompleteEvent;
import com.cyngofokglobal.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        /*Create the Verification Token for the User With Link*/

        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        /*Send Mail to User*/
        String url =
                event.getApplicationUrl()
                + "/verifyRegistration?token="
                + token;
//       SendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
    }
}
