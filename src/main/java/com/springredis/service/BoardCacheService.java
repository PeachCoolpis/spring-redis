package com.springredis.service;

import com.springredis.entity.Board;
import com.springredis.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardCacheService {
    
    private final BoardRepository boardRepository;
    
    @Cacheable(
            cacheNames = "getBoard",
            key = "'board:page:' + #page.pageNumber + ':size:' + #page.pageSize",
            cacheManager = "boardCacheManager"
    )
    public List<Board> getBoardFromCache(Pageable page) {
        return boardRepository.findAllBoards(page).getContent();   // 캐싱은 List만
    }
}
