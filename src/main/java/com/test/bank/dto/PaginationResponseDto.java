package com.test.bank.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaginationResponseDto {
    private List<PostDto> content;
    private int page;
    private int size;
    private int totalElements;
    private int totalPages;

}
