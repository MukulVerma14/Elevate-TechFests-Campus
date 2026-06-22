package com.example.ksep.dto;

import lombok.Builder;

@Builder
public record RegisterRequestDto(
        String email,
        String password,
        String role,
        String name
) {}
