package com.example.likelion_mini2.repository;

import com.example.likelion_mini2.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findByBoard_Id(Integer boardId); // 게시글 ID로 댓글 목록 조회
}
