package com.example.ksep.controllers;

import com.example.ksep.dto.CorporateProfileResponseDto;
import com.example.ksep.dto.DealClosureResponseDto;
import com.example.ksep.dto.ProgrammeResponseDto;
import com.example.ksep.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/programmes")
    public ResponseEntity<List<ProgrammeResponseDto>> getAllProgrammes() {
        return ResponseEntity.ok(adminService.getAllProgrammes());
    }

    @GetMapping("/deals")
    public ResponseEntity<List<DealClosureResponseDto>> getAllDeals() { // Assuming DealClosureResponse record exists
        return ResponseEntity.ok(adminService.getAllDeals());
    }

    @GetMapping("/corporates")
    public ResponseEntity<List<CorporateProfileResponseDto>> getAllCorporates() { // Assuming CorporateProfileResponse record exists
        return ResponseEntity.ok(adminService.getAllCorporates());
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getPlatformStats() {
        // Returns a fast JSON object like: {"totalProgrammes": 42, "dealsClosed": 12, "activeExpressions": 89}
        return ResponseEntity.ok(adminService.getPlatformStats());
    }
}
