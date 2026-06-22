package com.example.ksep.dto;

public record CorporateProfileResponseDto(
        Long id,
        String companyName,
        String type,
        String intent
) {}
