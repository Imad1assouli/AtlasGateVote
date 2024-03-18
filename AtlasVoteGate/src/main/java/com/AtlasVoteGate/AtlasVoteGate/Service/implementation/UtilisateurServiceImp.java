package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;


import com.AtlasVoteGate.AtlasVoteGate.Repository.UtilisateurRepo;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.UtilisateurService;
import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtilisateurServiceImp implements UtilisateurService {

    private UtilisateurRepo utilisateurRepo;
    private PasswordEncoder bcryptEncoder;

    public UtilisateurServiceImp(UtilisateurRepo utilisateurRepo, PasswordEncoder bcryptEncoder) {
        this.utilisateurRepo = utilisateurRepo;
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public Utilisateur save(Utilisateur user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return utilisateurRepo.save(user);
    }


    @Override
    public Utilisateur getUtilisateur(String login) {
        return utilisateurRepo.findByLogin(login);
    }
}
