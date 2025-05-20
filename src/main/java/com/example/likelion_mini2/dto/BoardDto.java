package com.example.likelion_mini2.dto;

import com.example.likelion_mini2.entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class BoardDto {
    private Integer id;
    private String title;
    private String content;

    private int views;
    private int boomUp;
    private int boomDown;
    private int bookmarks;
    private LocalDateTime createdDate;

    //생성자
    public BoardDto(){}

    //Entity에서 Dto로 변환
    public static BoardDto fromEntity(BoardEntity entity){
        BoardDto dto = new BoardDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setViews(entity.getViews());
        dto.setBoomUp(entity.getBoomUp());
        dto.setBoomDown(entity.getBoomDown());
        dto.setBookmarks(entity.getBookmarks());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }
    
    //Dto에서 Entity로 변환 (생성할 때 사용함)
    public BoardEntity toEntity(){
        BoardEntity entity = new BoardEntity();
        entity.setTitle(this.title);
        entity.setContent(this.content);
        return entity;
    }
}
