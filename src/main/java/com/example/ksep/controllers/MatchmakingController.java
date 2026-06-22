package com.example.ksep.controllers;

import com.example.ksep.dto.DealClosureRequestDto;
import com.example.ksep.dto.EoiResponseDto;
import com.example.ksep.services.MatchmakingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor
public class MatchmakingController {

    private final MatchmakingService matchmakingService;

    @GetMapping("/results")
    public ResponseEntity<List<EoiResponseDto>> getMatchedPairs() {
        return ResponseEntity.ok(matchmakingService.getAllMatchedPairs());
    }

    @PostMapping("/close/{id}")
    public ResponseEntity<Void> markDealClosed(@PathVariable Long id, @RequestBody DealClosureRequestDto request) {
        // Enforce the path variable matches the payload to prevent data mismatches
        if (!id.equals(request.eoiId())) {
            return ResponseEntity.badRequest().build();
        }
        matchmakingService.closeDeal(request);
        return ResponseEntity.ok().build();
    }
}
