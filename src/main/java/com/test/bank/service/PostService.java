package com.test.bank.service;

import com.test.bank.dto.PostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private RestTemplate restTemplate;

    public List<PostDto> getPost (){
        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<PostDto[]>response = restTemplate.getForEntity(url,PostDto[].class);
        PostDto[] postDtos = response.getBody();
        List<PostDto> postDtoList = Arrays.asList(postDtos);


        return postDtoList;
    }




}
