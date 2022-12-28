package com.example.kjkboard.service;

import com.example.kjkboard.dto.BoardAnswerDto;
import com.example.kjkboard.dto.BoardRequestDto;
import com.example.kjkboard.entity.Board;
import com.example.kjkboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional(readOnly = true)
    public  Board getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return board;
    }
    @Transactional
    public Board createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return board;
    }
    @Transactional
    public BoardAnswerDto updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(requestDto.getPassword().equals(board.getPassword())){
            board.update(requestDto);
        }
        return new BoardAnswerDto(board);
    }
    @Transactional
    public String deleteBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존제하지 않습니다")
        );
        if(requestDto.getPassword().equals(board.getPassword())){
            boardRepository.deleteById(id);
            return "삭제가 완료 되었습니다";
        }
        return "비밀번호가 일치하지 않습니다";
    }


}
