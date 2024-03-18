package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;


import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;

public interface UtilisateurService {

    Utilisateur save(Utilisateur user);

    Utilisateur getUtilisateur(String login);

}
