package com.boot.board_240718.service;

import com.boot.board_240718.model.Role;
import com.boot.board_240718.model.User;
import com.boot.board_240718.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//  password 암호화
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
//      사용자 패스워드를 가져와서 암호화
        String encodedPassword = passwordEncoder.encode(user.getPassword());
//      암호화된 패스워드를 비밀번호로 저장
        user.setPassword(encodedPassword);
//      활성화된 사용자
        user.setEnabled(true);

        Role role = new Role();
//      roll repository 안만들고, 하드코딩으로 1 저장(자동 증가)
        role.setId(1L);
//      user_role 테이블에 저장
        user.getRoles().add(role);

        return userRepository.save(user);
    }

}