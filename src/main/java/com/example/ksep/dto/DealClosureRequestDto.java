package com.example.ksep.dto;

import lombok.Builder;

@Builder
public record DealClosureRequestDto(
        Long eoiId,
        String campusDeliverable,
        String corporateDeliverable
) {}
