package com.example.ksep.repository;

import com.example.ksep.models.ExpressionOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressionOfInterestRepository extends JpaRepository<ExpressionOfInterest, Long> {
    // For Corporate: GET /api/corporate/interests (My shortlist)
    List<ExpressionOfInterest> findByCorporateId(Long corporateId);

    // For Campus: GET /api/campus/interests/{progId} (See who applied)
    static List<ExpressionOfInterest> findByProgrammeId(Long programmeId) {
        return null;
    }

    // Check if a corporate already expressed interest to prevent duplicates
    boolean existsByCorporateIdAndProgrammeId(Long corporateId, Long programmeId);
}
