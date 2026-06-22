package com.example.ksep.dto;

import lombok.Builder;

@Builder
public record EoiRequestDto(
        Long programmeId,
        String intentMessage
) {}
