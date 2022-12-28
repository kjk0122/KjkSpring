package com.example.kjkboard.controller;

import com.example.kjkboard.dto.BoardRequestDto;
import com.example.kjkboard.entity.Board;
import com.example.kjkboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/api/boards")   //조회
    public List<Board> getBoards() {return boardService.getBoards(); }

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }
    @GetMapping("/api/boards/{id}")
    public Long getBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.getBoard(id, requestDto);
    }
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.updateBoard(id, requestDto);
    }
    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }

}
