package com.isp392.ecommerce.service;
//import class

import com.isp392.ecommerce.dto.request.ResetPasswordRequest;
import com.isp392.ecommerce.dto.request.UpdatePasswordRequest;
import com.isp392.ecommerce.dto.request.UserCreationRequest;
import com.isp392.ecommerce.dto.request.UserUpdateRequest;
import com.isp392.ecommerce.dto.response.UserResponse;
import com.isp392.ecommerce.entity.OtpToken;
import com.isp392.ecommerce.entity.User;
import com.isp392.ecommerce.enums.Role;
import com.isp392.ecommerce.exception.AppException;
import com.isp392.ecommerce.exception.ErrorCode;
import com.isp392.ecommerce.mapper.UserMapper;
import com.isp392.ecommerce.repository.OtpTokenRepository;
import com.isp392.ecommerce.repository.UserRepository;
//framework
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//return type
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    OtpTokenRepository otpTokenRepository;
    JavaMailSender mailSender;


    @NonFinal
    @Value("${spring.mail.username}")
    protected String SENDER_EMAIL;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {// findById() return Optional DType
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User create(UserCreationRequest createRequest) {
        User user = userMapper.toUser(createRequest);
        user.setPassword(passwordEncoder().encode(createRequest.getPassword()));

        user.setRole(Role.CUSTOMER.name());
        if(userRepository.existsByPhone(createRequest.getPhone()))
            throw new AppException(ErrorCode.PHONE_EXISTED);
        if (userRepository.existsByUsername(createRequest.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        if (userRepository.existsByEmail(createRequest.getEmail()))
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        return userRepository.save(user);
    }

    public UserResponse getMyInfo() {
        return userMapper.toUserResponse(getCurrentUser());
    }

    public UserResponse updateMyInfo(UserUpdateRequest request) {
        User user = getCurrentUser();
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void updatePassword(UpdatePasswordRequest request) {
        //Get current user who is login
        User user = getCurrentUser();
        //Check if the old password match the current
        if (passwordEncoder().matches(request.getOldPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.WRONG_PASSWORD);
        }
        //Check if the new password match the current
        if (passwordEncoder().matches(request.getNewPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.MATCH_OLD_PASSWORD);
        }
        //Save new password
        user.setPassword(passwordEncoder().encode(request.getNewPassword()));
        userRepository.save(user);
    }


    public String forgotPassword(String email) {
        //Check username
        if (!userRepository.existsByEmail(email)) {
            throw new AppException(ErrorCode.EMAIL_NOT_EXISTED);
        }
        Random random = new Random();
        int otp;
        do {
            //random otp 6 digit number
            otp = random.nextInt(100000, 999999);
        }while (otpTokenRepository.existsById(otp));//Generate new if this otp has been created
        //Create email by SimpleMailMessage
        mailSender.send(getSimpleMailMessage(email, otp));
        otpTokenRepository.save(OtpToken.builder()
                .email(email)
                .otp(otp)
                .expiryTime(new Date(Instant.now()
                        .plus(5, ChronoUnit.MINUTES).toEpochMilli()))
                .build());

        return email;
    }

    public void resetPassword(ResetPasswordRequest request){
        //Get user who has been verified forgot password
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.EMAIL_NOT_EXISTED));
        //Check if reset password matches the old
        if (passwordEncoder().matches(request.getPassword(), user.getPassword()))
            throw new AppException(ErrorCode.MATCH_OLD_PASSWORD);
        //encode password
        user.setPassword(passwordEncoder().encode(request.getPassword()));
        userRepository.save(user);
    }

    private SimpleMailMessage getSimpleMailMessage(String email, int otp) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Forgot password");
        simpleMailMessage.setText("Hello " + email + ",\n\n" +
                "We have received a request to reset the password for your account. " +
                "Please use the following 6-digit OTP to verify your identity:\n\n" + otp +
                "\n\nThis code is valid for the next 5 minutes.");
        simpleMailMessage.setFrom(SENDER_EMAIL);
        return simpleMailMessage;
    }

    public User updateUser(String id, UserUpdateRequest request) {

//        User user = getUserById(id);
//        if(!(request.getFullName().isEmpty() || request.getFullName().isBlank())){
//            user.setFullName(request.getFullName());
//        }else throw new AppException(ErrorCode.FULLNAMEEMPTY);
//        if(!(request.getPhone().isEmpty() || request.getPhone().isBlank())){
//            user.setPhone(request.getPhone());
//        }else throw new AppException(ErrorCode.PHONEEMPTY);
//        if(!(request.getAddress().isEmpty() || request.getAddress().isBlank())){
//            user.setAddress(request.getAddress());
//        }else throw new AppException(ErrorCode.ADDRESSEMPTY);
//
//        return userRepository.save(user);
        return null;
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    public User getCurrentUser() {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        return User.builder()
                .build();
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}