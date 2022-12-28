package com.example.kjkboard.repository;

import com.example.kjkboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc(); //수정된 시간이 가장 최근


}
