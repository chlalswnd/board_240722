package com.boot.board_240718.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    // 크기가 2에서 30 사이여야 합니다
//    @Size(min=2, max=30)
    @Size(min=2, max=30, message = "제목 2글자 이상으로ㄱ")
    private String title;
    private String content;
}
