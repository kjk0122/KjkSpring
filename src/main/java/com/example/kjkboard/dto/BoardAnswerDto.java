package com.example.kjkboard.dto;

import com.example.kjkboard.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class BoardAnswerDto {
    private final String username;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final Long id;
    public BoardAnswerDto(Board board) {
        this.username = board.getUsername();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
        this.id = board.getId();
    }

}
