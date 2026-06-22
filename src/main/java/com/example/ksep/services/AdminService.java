package com.example.ksep.services;

import com.example.ksep.dto.CorporateProfileResponseDto;
import com.example.ksep.dto.DealClosureResponseDto;
import com.example.ksep.dto.ProgrammeResponseDto;
import com.example.ksep.repository.CorporateProfileRepository;
import com.example.ksep.repository.DealClosureRepository;
import com.example.ksep.repository.ExpressionOfInterestRepository;
import com.example.ksep.repository.ProgrammeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final ProgrammeRepository programmeRepository;
    private final DealClosureRepository dealClosureRepository;
    private final CorporateProfileRepository corporateProfileRepository;
    private final ExpressionOfInterestRepository eoiRepository;

    @Transactional(readOnly = true)
    public List<ProgrammeResponseDto> getAllProgrammes() {
        return programmeRepository.findAll().stream()
                .map(p -> new ProgrammeResponseDto(
                        p.getId(), p.getCampus().getId(), p.getCampus().getCampusName(),
                        p.getTitle(), p.getType().name(), p.getDomain(), p.getLocation(), p.getStatus().name()
                )).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<DealClosureResponseDto> getAllDeals() {
        return dealClosureRepository.findAll().stream()
                .map(deal -> new DealClosureResponseDto(
                        deal.getId(),
                        deal.getEoi().getProgramme().getId(),
                        deal.getEoi().getProgramme().getTitle(),
                        deal.getEoi().getProgramme().getCampus().getCampusName(),
                        deal.getEoi().getCorporate().getCompanyName(),
                        deal.getClosedAt()
                )).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CorporateProfileResponseDto> getAllCorporates() {
        return corporateProfileRepository.findAll().stream()
                .map(c -> new CorporateProfileResponseDto(
                        c.getId(), c.getCompanyName(), c.getType().name(), c.getIntent()
                )).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Map<String, Object> getPlatformStats() {
        Map<String, Object> stats = new HashMap<>();

        long totalProgrammes = programmeRepository.count();
        long totalDeals = dealClosureRepository.count();
        long activeExpressions = eoiRepository.count(); // Could filter by PENDING status if desired
        long totalCorporates = corporateProfileRepository.count();

        stats.put("totalProgrammes", totalProgrammes);
        stats.put("totalDealsClosed", totalDeals);
        stats.put("totalActiveExpressions", activeExpressions);
        stats.put("totalCorporates", totalCorporates);

        return stats;
    }
}
