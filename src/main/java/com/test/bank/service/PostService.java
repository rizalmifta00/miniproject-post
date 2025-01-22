package com.test.bank.service;

import com.test.bank.dto.PostDto;
import com.test.bank.exception.CustomException;
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

    public List<PostDto> getPost (int page, int pageSize){
        validatePagination(page, pageSize);

        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<PostDto[]> response = restTemplate.getForEntity(url, PostDto[].class);

        if (response.getBody() == null) {
            throw new CustomException("Failed to fetch posts from external API", 500);
        }

        List<PostDto> postDtoList = Arrays.asList(response.getBody());


        int fromIndex = Math.min((page - 1) * pageSize, postDtoList.size());
        int toIndex = Math.min(fromIndex + pageSize, postDtoList.size());
        return postDtoList.subList(fromIndex, toIndex);
    }

    private void validatePagination(int page, int pageSize) {
        if (page < 1) {
            throw new CustomException("Page must be greater than or equal to 1", 400);
        }
        if (pageSize < 1 || pageSize > 100) {
            throw new CustomException("Page size must be between 1 and 100", 400);
        }
    }




}
