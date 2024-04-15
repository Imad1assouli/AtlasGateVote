package com.AtlasVoteGate.AtlasVoteGate.model;

import com.AtlasVoteGate.AtlasVoteGate.enums.AppointmentStatus;
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
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String cne;


    private String email;


    private String password; // Storing hashed version for security.


    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)

    private AppointmentStatus status;


    private String nom;


    private String prenom;

    // Existing appointment fields...
}
