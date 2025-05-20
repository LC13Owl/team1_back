package com.example.likelion_mini2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;

    private int views = 0;        // 조회수
    private int boomUp = 0;       // 좋아요
    private int boomDown = 0;     // 싫어요
    private int bookmarks = 0;    // 북마크 수

    private LocalDateTime createdDate = LocalDateTime.now();  // 작성일

    // 기본 생성자
    public BoardEntity() {
    }

    // 생성자 추가 가능 (필요하면)
    public BoardEntity(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
    }

    // Getter & Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getBoomUp() {
        return boomUp;
    }

    public void setBoomUp(int boomUp) {
        this.boomUp = boomUp;
    }

    public int getBoomDown() {
        return boomDown;
    }

    public void setBoomDown(int boomDown) {
        this.boomDown = boomDown;
    }

    public int getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(int bookmarks) {
        this.bookmarks = bookmarks;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdAt) {
        this.createdDate = createdAt;
    }
}
