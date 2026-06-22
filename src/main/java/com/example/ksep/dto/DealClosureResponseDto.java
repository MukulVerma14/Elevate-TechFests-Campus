package com.example.ksep.dto;

import java.time.LocalDateTime;

public record DealClosureResponseDto(
        Long dealId,
        Long programmeId,
        String programmeTitle,
        String campusName,
        String corporateName,
        LocalDateTime closedAt
) {}
