package com.bvlabs.d4auctioneer.infra.dto.offer;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record GetOffersRequest(
        @Schema(example = "1")
        Integer pageNumber,
        @Schema(example = "softcore")
        String seasonType,
        @Schema(example = "selling")
        String transactionType,
        @Schema(example = "Vex,Kaa")
        String runeNames,
        @Schema(example = "19000000")
        BigDecimal minAcceptableValue,
        @Schema(example = "300000000")
        BigDecimal desirableValue
) {
}
