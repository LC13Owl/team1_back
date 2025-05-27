package com.example.likelion_mini2.service;

import com.example.likelion_mini2.dto.CommentDto;
import com.example.likelion_mini2.entity.BoardEntity;
import com.example.likelion_mini2.entity.CommentEntity;
import com.example.likelion_mini2.repository.BoardRepository;
import com.example.likelion_mini2.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // 댓글 작성
    public CommentDto addComment(Integer boardId, String content) {
        BoardEntity board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        CommentEntity comment = new CommentEntity(content, board);
        CommentEntity saved = commentRepository.save(comment);
        return CommentDto.fromEntity(saved);
    }

    // 게시글에 달린 댓글 전체 조회
    public List<CommentDto> getCommentsByBoardId(Integer boardId) {
        return commentRepository.findByBoard_Id(boardId).stream()
                .map(CommentDto::fromEntity)
                .collect(Collectors.toList());
    }

    // 댓글 삭제
    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }
}
