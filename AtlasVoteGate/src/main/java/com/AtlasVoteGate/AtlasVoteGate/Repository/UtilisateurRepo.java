package com.AtlasVoteGate.AtlasVoteGate.Repository;


import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
public interface UtilisateurRepo  extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByLogin(String login);

}
