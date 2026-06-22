package com.example.ksep.dto;

import lombok.Builder;

@Builder
public record EoiResponseDto(
        Long id,
        Long corporateId,
        String companyName,
        Long programmeId,
        String programmeTitle,
        String status
) {}
