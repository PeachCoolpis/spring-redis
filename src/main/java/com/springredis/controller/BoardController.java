package com.springredis.controller;

import com.springredis.entity.Board;
import com.springredis.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/boards")
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService  boardService;
    
    @GetMapping
    public PageResponse<Board> getBoards(@PageableDefault(page = 0,size = 10) Pageable page) {
        Page<Board> board = boardService.getBoard(page);
        return PageResponse.from(board);
    }
}
