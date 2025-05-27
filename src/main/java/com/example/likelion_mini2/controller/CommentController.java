package com.example.likelion_mini2.controller;

import com.example.likelion_mini2.dto.CommentDto;
import com.example.likelion_mini2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor

public class CommentController {
    private final CommentService commentService;
    @GetMapping("/{boardId}")
    public List<CommentDto> findAll(@PathVariable Integer boardId) {
        return commentService.getCommentsByBoardId(boardId);
    }
    @PostMapping("/create/{boardId}")
    public CommentDto create(@PathVariable Integer boardId, @RequestBody CommentDto dto) {
        return commentService.addComment(boardId, dto.getContent());
    }
    @DeleteMapping("/delete/{commentId}")
    public void delete(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
    }
}
