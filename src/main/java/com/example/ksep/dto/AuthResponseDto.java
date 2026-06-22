package com.example.ksep.dto;

import lombok.Builder;

@Builder
public record AuthResponseDto(
        String token,
        Long userId,
        String role
) {}
