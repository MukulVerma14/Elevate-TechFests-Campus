package com.example.ksep.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "deal_closures")
public class DealClosure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eoi_id", nullable = false)
    private ExpressionOfInterest eoi;

    @Column(columnDefinition = "TEXT")
    private String campusDeliverable;

    @Column(columnDefinition = "TEXT")
    private String corporateDeliverable;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime closedAt;
}
