package com.isp392.ecommerce.configuartion;

import com.isp392.ecommerce.entity.User;
import com.isp392.ecommerce.enums.Role;
import com.isp392.ecommerce.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Slf4j
@Configuration
public class ApplicationInitConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
               if(userRepository.findByUsername("admin").isEmpty()){

                   User user = User.builder()
                           .username("admin")
                           .password(passwordEncoder.encode("admin"))
                           .role(Role.ADMIN.toString())
                           .build();
                    userRepository.save(user);
                    log.info("admin account create success");

               }

        };
    }


}
