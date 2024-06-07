package ru.mtsbank.customservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mtsbank.customservice.dto.UserDTO;
import ru.mtsbank.customservice.jwt.JwtUtil;
import ru.mtsbank.customservice.service.CustomUserDetailService;
import ru.mtsbank.customservice.userdetail.CustomerUserDetail;

@RestController
@RequestMapping("/mtsbank")
public class AuthController {
    private final CustomUserDetailService customUserDetailService;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private CustomUserDetailService customerUserDetail;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailService customerUserDetail, CustomUserDetailService customUserDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customerUserDetail = customerUserDetail;
        this.customUserDetailService = customUserDetailService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> createAuthToken(@RequestBody UserDTO userDTO){
        logger.info(userDTO.toString());
        CustomerUserDetail customerUserDetail = (CustomerUserDetail) customUserDetailService.loadUserByUsername(userDTO.getPhoneNumber());
        logger.info(customerUserDetail.getBankAccountId());
        logger.info(customerUserDetail.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getPhoneNumber(), userDTO.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.getToken(customerUserDetail);
        logger.info(token);
        return ResponseEntity.ok(token);
    }

}
