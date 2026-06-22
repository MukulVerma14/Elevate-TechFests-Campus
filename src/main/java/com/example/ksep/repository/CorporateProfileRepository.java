package com.example.ksep.repository;

import com.example.ksep.models.CorporateProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CorporateProfileRepository extends JpaRepository<CorporateProfile, Long> {
    Optional<CorporateProfile> findByUserId(Long userId);
}
