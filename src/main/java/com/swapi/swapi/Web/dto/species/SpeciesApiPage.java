package com.swapi.swapi.Web.dto.species;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@EqualsAndHashCode
public class SpeciesApiPage<T> {
    private List<T> content;
    private SpeciesApiPage.PaginationMetadata pagination;

    public SpeciesApiPage(Page<T> springPage) {
        this.content = springPage.getContent();
        this.pagination = SpeciesApiPage.PaginationMetadata.builder().currentPage(springPage.getPageable().getPageNumber())
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