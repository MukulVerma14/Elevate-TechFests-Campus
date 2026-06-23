package com.example.ksep.repository;

import com.example.ksep.models.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme, Long> {

        // Used by CampusService to fetch a campus's own programmes
        List<Programme> findByCampusId(Long campusId);

        // Used by MatchmakingService to browse the pool with optional filters
        @Query("SELECT p FROM Programme p WHERE " +
                        "p.status = 'ACTIVE' AND " +
                        "(:domain IS NULL OR LOWER(p.domain) = LOWER(:domain)) AND " +
                        "(:location IS NULL OR LOWER(p.location) = LOWER(:location)) AND " +
                        "(:type IS NULL OR CAST(p.type AS string) = :type)")
        List<Programme> findAvailableProgrammes(
                        @Param("domain") String domain,
                        @Param("location") String location,
                        @Param("type") String type);

        // Used by AdminService
        @Query("SELECT COUNT(p) FROM Programme p WHERE p.status = 'ACTIVE'")
        Long countActiveProgrammes();

}
