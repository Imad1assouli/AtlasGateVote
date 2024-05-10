package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;


import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    Utilisateur save(Utilisateur user);

    Utilisateur getUtilisateur(String login);
    Utilisateur getUserById(Long UserId);

    void deleteUtilisateur(Long idUser);

    void update(Long idUser,Utilisateur user);
    List<Utilisateur> getAllVoters();
    List<Utilisateur> getAllFunctionaries();

    List<Utilisateur> getAllDemandeur();

    List<Utilisateur> getAllUsers();

    void makeVoter (Long idDemandeur);


}
