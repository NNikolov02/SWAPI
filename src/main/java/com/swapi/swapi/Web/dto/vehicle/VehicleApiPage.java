package com.swapi.swapi.Web.dto.vehicle;

import com.swapi.swapi.Web.dto.starships.StarshipsApiPage;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Page;

import java.util.List;


@Data
@EqualsAndHashCode
public class VehicleApiPage<T> {

    private List<T> content;
    private VehicleApiPage.PaginationMetadata pagination;

    public VehicleApiPage(Page<T> springPage) {
        this.content = springPage.getContent();
        this.pagination = VehicleApiPage.PaginationMetadata.builder().currentPage(springPage.getPageable().getPageNumber())
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
