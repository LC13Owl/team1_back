package com.example.likelion_mini2.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity board;

    public CommentEntity() {}

    public CommentEntity(String content, BoardEntity board) {
        this.content = content;
        this.board = board;
        this.createdAt = LocalDateTime.now();
    }
    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BoardEntity getBoard() {
        return board;
    }
    public void setBoard(BoardEntity board) {
        this.board = board;
    }
}
