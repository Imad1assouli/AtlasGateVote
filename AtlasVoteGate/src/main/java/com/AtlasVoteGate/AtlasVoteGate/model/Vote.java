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
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoral_party_id", nullable = false)
    private ElectoralParty electoralParty;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Vote(User user, ElectoralParty electoralParty, LocalDateTime timestamp) {
        this.user = user;
        this.electoralParty = electoralParty;
        this.timestamp = timestamp;
    }
}
