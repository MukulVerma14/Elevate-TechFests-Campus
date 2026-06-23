package com.example.ksep.dto;

public record DealClosureResponseDto(
        Long dealId,
        Long eoiId,
        String programmeTitle,
        String corporateName,
        String campusDeliverable,
        String corporateDeliverable
) {}
