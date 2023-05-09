package com.swapi.swapi.dto.starships;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Page;

import java.util.List;
@Data
@EqualsAndHashCode
public class StarshipsApiPage<T> {
    private List<T> content;
    private StarshipsApiPage.PaginationMetadata pagination;

    public StarshipsApiPage(Page<T> springPage) {
        this.content = springPage.getContent();
        this.pagination = StarshipsApiPage.PaginationMetadata.builder().currentPage(springPage.getPageable().getPageNumber())
                .pageSize(springPage.getPageable().getPageSize())
                .totalElement(springPage.getTotalElements())
                .totalPages(springPage.getTotalPages())
                .build();
    }

    @Data
    @Builder
    private static class PaginationMetadata {

        private Integer currentPage;
        private Integer pageSize;
        private Integer totalPages;
        private Long totalElement;
    }
}
