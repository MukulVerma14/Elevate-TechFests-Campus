package com.example.ksep.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programmes", indexes = {
        @Index(name = "idx_domain", columnList = "domain"),
        @Index(name = "idx_location", columnList = "location")
})
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id", nullable = false)
    private CampusProfile campus;

    private String title;

    @Enumerated(EnumType.STRING)
    private ProgrammeType type;

    private String domain;
    private String subDomain;
    private String location;
    private String scale;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer participantsCount;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Boolean feeBased;

    @Enumerated(EnumType.STRING)
    private ProgrammeStatus status;

    // Cascades deletes: if a programme is deleted, its terms are removed too.
    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgrammeParticipationTerm> terms;
}
