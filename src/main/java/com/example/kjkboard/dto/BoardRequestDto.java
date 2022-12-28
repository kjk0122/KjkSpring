package com.example.kjkboard.dto;

import lombok.Getter;


@Getter
public class BoardRequestDto { //여기가 DTO에 담아서 반환
    private String username;
    private String title;
    private String password;
    private String contents;
}