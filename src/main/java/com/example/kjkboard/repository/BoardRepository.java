package com.example.kjkboard.repository;

import com.example.kjkboard.entity.Board;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtDesc(); //수정된 시간이 가장 최근

    @Override
    List<Board> findAll();

    @Override
    List<Board> findAll(Sort sort);

    @Override
    List<Board> findAllById(Iterable<Long> longs);

    @Override
    <S extends Board> List<S> saveAll(Iterable<S> entities);

    @Override
    void flush();

    @Override
    <S extends Board> S saveAndFlush(S entity);

    @Override
    <S extends Board> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Board> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Board getOne(Long aLong);

    @Override
    Board getById(Long aLong);

    @Override
    Board getReferenceById(Long aLong);

    @Override
    <S extends Board> List<S> findAll(Example<S> example);

    @Override
    <S extends Board> List<S> findAll(Example<S> example, Sort sort);

    @Override
    Page<Board> findAll(Pageable pageable);

    @Override
    <S extends Board> S save(S entity);

    @Override
    Optional<Board> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Board entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Board> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Board> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Board> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Board> long count(Example<S> example);

    @Override
    <S extends Board> boolean exists(Example<S> example);

    @Override
    <S extends Board, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
