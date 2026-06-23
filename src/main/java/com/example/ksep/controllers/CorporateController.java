package com.example.ksep.controllers;

import com.example.ksep.dto.EoiRequestDto;
import com.example.ksep.dto.EoiResponseDto;
import com.example.ksep.dto.ProgrammeResponseDto;
import com.example.ksep.services.MatchmakingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/corporate")
@RequiredArgsConstructor
public class CorporateController {

    private final MatchmakingService matchmakingService;

    @GetMapping("/programmes")
    public ResponseEntity<List<ProgrammeResponseDto>> browsePool(
            @RequestParam(required = false) String domain,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String type) {
        return ResponseEntity.ok(matchmakingService.browseProgrammes(domain, location, type));
    }

    @PostMapping("/interest/{progId}")
    public ResponseEntity<EoiResponseDto> expressInterest(Principal principal, @PathVariable Long progId, @RequestBody EoiRequestDto request) {
        Long userId = extractUserId(principal);
        return ResponseEntity.ok(matchmakingService.expressInterest(userId, progId, request));
    }

    @GetMapping("/interests")
    public ResponseEntity<List<EoiResponseDto>> getMyShortlist(Principal principal) {
        Long userId = extractUserId(principal);
        return ResponseEntity.ok(matchmakingService.getCorporateInterests(userId));
    }

    @DeleteMapping("/interest/{progId}")
    public ResponseEntity<Void> withdrawInterest(Principal principal, @PathVariable Long progId) {
        Long userId = extractUserId(principal);
        matchmakingService.withdrawInterest(userId, progId);
        return ResponseEntity.noContent().build();
    }

    private Long extractUserId(Principal principal) {
        return Long.parseLong(principal.getName());
    }
}
