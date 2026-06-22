package com.example.ksep.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ProgrammeRequestDto(
        String title,
        String type,
        String domain,
        String subDomain,
        String location,
        String scale,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer participantsCount,
        String description,
        Boolean feeBased
) {}
