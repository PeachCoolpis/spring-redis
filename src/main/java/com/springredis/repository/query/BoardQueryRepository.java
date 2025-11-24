package com.springredis.repository.query;

import com.springredis.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardQueryRepository {
    Page<Board> findAllBoards(Pageable page);
    
    Long boardCount();
}
