package com.team8.aichatbotproject.controller;

import com.team8.aichatbotproject.domain.User;
import com.team8.aichatbotproject.dto.UserDTO;
import com.team8.aichatbotproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        // 패스워드와 확인 패스워드 일치 확인
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("비밀번호를 다시 입력하세요.");
        }

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAge(userDTO.getAge());
        user.setJob(userDTO.getJob());
        user.setEducationLevel(userDTO.getEducationLevel());

        userRepository.save(user);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
        User user = userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        if (user == null) {
            return ResponseEntity.status(401).body("이메일이나 비밀번호 오류");
        }
        return ResponseEntity.ok("로그인 성공");
    }
}
