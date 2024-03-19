package com.AtlasVoteGate.AtlasVoteGate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User information fields
    private String cne;
    private String email;
    private String password; // Consider storing a hashed version for security.

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status;

    // Existing appointment fields...

    // Enum for appointment status for clarity and type safety
    public enum AppointmentStatus {
        PENDING_VERIFICATION,
        VERIFIED,
        CANCELED
    }

}
