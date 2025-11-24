package com.springredis.service;

import com.springredis.entity.Board;
import com.springredis.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    
    private final BoardRepository boardRepository;
    
    public Page<Board> getBoard(Pageable page) {
         return boardRepository.findAllBoards(page);
    }
}
