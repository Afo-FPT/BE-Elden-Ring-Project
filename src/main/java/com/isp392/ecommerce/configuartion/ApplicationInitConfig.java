//package com.isp392.ecommerce.configuartion;
//
//import com.isp392.ecommerce.entity.User;
//import com.isp392.ecommerce.repository.UserRepository;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashSet;
//
//@Configuration
//public class ApplicationInitConfig {
//
//    @Bean
//    ApplicationRunner applicationRunner(UserRepository userRepository){
//        return args -> {
//               userRepository.findByUsername("admin").isEmpty(){
//                   var roles = new HashSet<>()
//                   User user = User.builder()
//                           .username("admin")
//                           .role()
//                           .build();
//            }
//        };
//    }
//
//
//}
