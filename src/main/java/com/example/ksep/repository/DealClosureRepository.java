package com.example.ksep.repository;

import com.example.ksep.models.DealClosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealClosureRepository extends JpaRepository<DealClosure, Long> {
    // For admin tracking or final dashboard metrics
    List<DealClosure> findByEoi_Programme_CampusId(Long campusId);
}
