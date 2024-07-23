package com.boot.board_240718.service;

import com.boot.board_240718.model.Board;
import com.boot.board_240718.model.Role;
import com.boot.board_240718.model.User;
import com.boot.board_240718.repository.BoardRepository;
import com.boot.board_240718.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board){
        User user = userRepository.findByUsername(username);
        board.setUser(user);

        return boardRepository.save(board);
    }
}