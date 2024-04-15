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
@Setter
@Getter
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Utilisateur user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoral_party_id", nullable = false)
    private ElectoralParty electoralParty;


    private LocalDateTime timestamp;

    public Vote(Utilisateur user, ElectoralParty electoralParty, LocalDateTime timestamp) {
        this.user = user;
        this.electoralParty = electoralParty;
        this.timestamp = timestamp;
    }
}
