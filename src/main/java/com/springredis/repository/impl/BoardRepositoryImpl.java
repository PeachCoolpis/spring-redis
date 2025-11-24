package com.springredis.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springredis.entity.Board;
import com.springredis.repository.query.BoardQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.springredis.entity.QBoard.board;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardQueryRepository {
    
    private final JPAQueryFactory queryFactory;
    
    
    @Override
    public Page<Board> findAllBoards(Pageable page) {
        
        List<Board> result = queryFactory
                .selectFrom(board)
                .orderBy(board.createdAt.desc())
                .offset(page.getOffset())
                .limit(page.getPageSize())
                .fetch();
        
        JPAQuery<Long> countQuery = queryFactory
                .select(board.count())
                .from(board);
        
        return PageableExecutionUtils.getPage(result, page, countQuery::fetchOne);
    }
    
    @Override
    public Long boardCount() {
        return queryFactory.select(board.count())
                .from(board)
                .fetchOne();
    }
}
