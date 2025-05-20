package com.example.likelion_mini2.service;

import com.example.likelion_mini2.dto.BoardDto;
import com.example.likelion_mini2.entity.BoardEntity;
import com.example.likelion_mini2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BoardService {
    private final BoardRepository boardRepository;
    public List<BoardDto> findAll(){
        List<BoardEntity> entities = boardRepository.findAll();
        List<BoardDto> dtoList = new ArrayList<>();
        for(BoardEntity entity:entities){
            dtoList.add(BoardDto.fromEntity(entity));
        }
        return dtoList;
    }
    public BoardDto findById(Integer id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        entity.setViews(entity.getViews() + 1); // 조회수 증가
        boardRepository.save(entity);
        return BoardDto.fromEntity(entity);
    }

    public BoardDto update(Integer id, BoardDto dto){
        BoardEntity entity = boardRepository.findById(id).orElse(null);
        if(entity != null){
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            return BoardDto.fromEntity(boardRepository.save(entity));
        }
        return null;
    }
    public void delete(Integer id){
        boardRepository.deleteById(id);
    }
    public BoardDto save(BoardDto dto) {
        BoardEntity entity = dto.toEntity();
        BoardEntity saved = boardRepository.save(entity);
        return BoardDto.fromEntity(saved);
    }

    public void boomUp(Integer id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        entity.setBoomUp(entity.getBoomUp() + 1);
        boardRepository.save(entity);
    }

    // 싫어요 증가
    public void boomDown(Integer id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        entity.setBoomDown(entity.getBoomDown() + 1);
        boardRepository.save(entity);
    }

    // 북마크 증가
    public void bookmark(Integer id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        entity.setBookmarks(entity.getBookmarks() + 1);
        boardRepository.save(entity);
    }
}
