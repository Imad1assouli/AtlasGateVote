package com.AtlasVoteGate.AtlasVoteGate.Repository;


import com.AtlasVoteGate.AtlasVoteGate.enums.Role;
import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;


@CrossOrigin("http://localhost:4200")
@Repository
public interface UtilisateurRepo  extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByLogin(String login);
    ArrayList<Utilisateur> findByRole(Role role);

}
