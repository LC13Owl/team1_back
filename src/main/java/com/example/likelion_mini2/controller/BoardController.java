package com.example.likelion_mini2.controller;

import com.example.likelion_mini2.dto.BoardDto;
import com.example.likelion_mini2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor

public class BoardController {
    public final BoardService boardService;
    @GetMapping//전체조회
    public List<BoardDto> finaAll(){
        return boardService.findAll();
    }
    @GetMapping("/read/{id}")
    public BoardDto findById(@PathVariable Integer id){
        return boardService.findById(id);
    }
    @PostMapping("/create/")
    public BoardDto create(@RequestBody BoardDto dto){
        return boardService.save(dto);
    }
    @PutMapping("/update/{id}")
    public BoardDto update(@RequestBody BoardDto dto, @PathVariable Integer id){
        return boardService.update(id,dto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        boardService.delete(id);
    }
    @PostMapping("/boomup/{id}")
    public void boomUp(@PathVariable Integer id){
        boardService.boomUp(id);
    }
    @PostMapping("/boomdown/{id}")
    public void boomDown(@PathVariable Integer id){
        boardService.boomDown(id);
    }
    @PostMapping("/bookmark/{id}")
    public void bookmark(@PathVariable Integer id){
        boardService.bookmark(id);
    }

}
