package com.example.likelion_mini2.dto;

import com.example.likelion_mini2.entity.CommentEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter

public class CommentDto {

    private Integer id;
    private String content;
    private LocalDateTime createdAt;
    private Integer boardId;
    public CommentDto(){}

    public static CommentDto fromEntity(CommentEntity entity) {
        CommentDto dto = new CommentDto();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setBoardId(entity.getBoard().getId());
        return dto;
    }
}
