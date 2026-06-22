package com.example.ksep.repository;

import com.example.ksep.models.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme, Long> {

    // For the Campus Dashboard: GET /api/campus/programmes
    // Spring infers the SQL automatically: SELECT * FROM programmes WHERE campus_id = ?
    List<Programme> findByCampusId(Long campusId);

    // For the Corporate Dashboard: GET /api/corporate/programmes
    // Handles dynamic filtering. If a param is null, it ignores that filter.
    @Query("SELECT p FROM Programme p WHERE " +
            "(:domain IS NULL OR p.domain = :domain) AND " +
            "(:location IS NULL OR p.location = :location) AND " +
            "(:type IS NULL OR p.type = :type) AND " +
            "p.status = 'ACTIVE'")
    List<Programme> findAvailableProgrammes(
            @Param("domain") String domain,
            @Param("location") String location,
            @Param("type") String type
    );
}
