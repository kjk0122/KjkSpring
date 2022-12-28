package com.example.kjkboard.controller;

import com.example.kjkboard.dto.BoardAnswerDto;
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
    @GetMapping("/api/boards/{id}") //단일조회
    public Board getBoard(@PathVariable Long id) {
        Board board = boardService.getBoard(id);
        return board;
    }
    @PostMapping("/api/boards") //글 게시
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }
    @PutMapping("/api/boards/{id}") //글 수정
    public BoardAnswerDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        BoardAnswerDto boardAnswerDto = boardService.updateBoard(id, requestDto);
        return boardAnswerDto;
    }
    @DeleteMapping("/api/boards/{id}")
    public String deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.deleteBoard(id, requestDto);
    }

}
