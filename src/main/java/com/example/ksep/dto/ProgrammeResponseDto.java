package com.example.ksep.dto;

import lombok.Builder;

@Builder
public record ProgrammeResponseDto(
        Long id,
        Long campusId,
        String campusName,
        String title,
        String type,
        String domain,
        String location,
        String status
) {}
