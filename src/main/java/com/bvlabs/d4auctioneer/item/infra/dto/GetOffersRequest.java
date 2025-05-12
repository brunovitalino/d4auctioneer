package com.bvlabs.d4auctioneer.item.infra.dto;

import com.bvlabs.d4auctioneer.item.domain.model.ItemType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record GetOffersRequest(
        @Schema(example = "1")
        Integer pageNumber,
        @Schema(example = "softcore")
        String seasonType,
        @Schema(example = "selling")
        String searchType,
        @Schema(example = "Vex,Kaa")
        String runeNames,
        @Schema(example = "200000000")
        BigDecimal minAcceptableValue,
        @Schema(example = "300000000")
        BigDecimal desirableValue
) {
}
