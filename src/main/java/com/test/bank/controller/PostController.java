package com.test.bank.controller;

import com.test.bank.dto.PostDto;
import com.test.bank.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getPost( @RequestParam(defaultValue = "1") int page,
                                                  @RequestParam(defaultValue = "10") int pageSize){
        List<PostDto> postDtos = postService.getPost(page, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(postDtos);
    }
}
