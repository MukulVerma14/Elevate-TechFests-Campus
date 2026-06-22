package com.example.ksep.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "corporate_profiles")
public class CorporateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String companyName;

    @Enumerated(EnumType.STRING)
    private CorporateType type;

    @Column(columnDefinition = "TEXT")
    private String intent;
}
