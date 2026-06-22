package com.example.ksep.repository;

import com.example.ksep.models.CampusProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampusProfileRepository extends JpaRepository<CampusProfile, Long> {
    Optional<CampusProfile> findByUserId(Long userId);
}
