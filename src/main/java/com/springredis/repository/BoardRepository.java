package com.springredis.repository;

import com.springredis.entity.Board;
import com.springredis.repository.query.BoardQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long>, BoardQueryRepository {

}
