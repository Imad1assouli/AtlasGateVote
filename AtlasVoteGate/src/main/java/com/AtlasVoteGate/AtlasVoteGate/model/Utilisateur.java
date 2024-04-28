package com.AtlasVoteGate.AtlasVoteGate.model;

import com.AtlasVoteGate.AtlasVoteGate.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String login;


    @Enumerated(EnumType.STRING)
    private Role role;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private String nom;


    private String prenom;

    public Utilisateur(String login, Role role, String password, String nom, String prenom) {
        this.login = login;
        this.role = role;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }
}
