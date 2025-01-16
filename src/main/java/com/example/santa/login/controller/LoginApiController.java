package com.example.santa.login.controller;

import com.example.santa.login.vo.UserDetailsVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/login")
public class LoginApiController {

    @GetMapping("/user")
    public ResponseEntity<?> getUser(HttpSession session) {
        UserDetailsVO userDetails = (UserDetailsVO) session.getAttribute("userDetails");
        if (userDetails != null) {
            // 디버깅: 사용자 정보 출력
            System.out.println("User ID: " + userDetails.getUserId());
            System.out.println("User Role: " + userDetails.getRole());
            return ResponseEntity.ok(userDetails); // 사용자 정보 반환
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }
    }
}

