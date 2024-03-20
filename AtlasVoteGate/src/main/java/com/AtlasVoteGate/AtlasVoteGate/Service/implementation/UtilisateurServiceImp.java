package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;


import com.AtlasVoteGate.AtlasVoteGate.Repository.UtilisateurRepo;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.UtilisateurService;
import com.AtlasVoteGate.AtlasVoteGate.enums.Role;
import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        try {
            log.info("Utilisateur creé avec succés");
            return utilisateurRepo.save(user);

        } catch (Exception e) {
            throw new RuntimeException("Error saving user: " + e.getMessage(), e);
        }
    }


    @Override
    public Utilisateur getUtilisateur(String login) {
        return utilisateurRepo.findByLogin(login);
    }

    /**
     * @param idUser
     */
    @Override
    public void delete(Long idUser) {
        try {
            utilisateurRepo.deleteById(idUser);
            log.info("Utilisateur supprimé avec succés");
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage(), e);
        }

    }
    /**
     * @param UserId
     * @return
     */
    @Override
    public Utilisateur getUserById(Long UserId) {
        Optional<Utilisateur> user= utilisateurRepo.findById(UserId);
        if(user.isPresent()){
            log.info("user trouvé avec l ' ID "+ UserId );
            return user.get();
        }
        else{
            log.warn("Aucun user trouvé avec l ' ID "+ UserId);
        }
        return null;
    }

    /**
     * @param idUser
     * @param newUser
     */
    @Override
    public void update(Long idUser, Utilisateur newUser) {
        Optional<Utilisateur> existingUser = utilisateurRepo.findById(idUser);
        if (existingUser.isPresent()) {
            Utilisateur userToUpdate = existingUser.get();

            // Mettez à jour les propriétés de l'utilisateur existant avec les nouvelles valeurs
            userToUpdate.setNom(newUser.getNom());
            userToUpdate.setPrenom(newUser.getPrenom());
            userToUpdate.setLogin(newUser.getLogin());
            userToUpdate.setPassword(newUser.getPassword());
            userToUpdate.setRole(newUser.getRole());

            // Sauvegardez l'utilisateur mis à jour
            utilisateurRepo.save(userToUpdate);
        }
        else {
            log.warn("aucun utilisateur existant avec cet ID "+idUser);
        }

    }

    /**
     * @return
     */
    @Override
    public List<Utilisateur> getAllVoters() {

        List<Utilisateur> listeVoters =utilisateurRepo.findByRole(Role.ROLE_VOTER);
        if (!listeVoters.isEmpty()){
            log.info("Liste des utilisateurs trouvé avec succés ");
            return listeVoters;
        }
        else {
            log.warn("Aucun utilisateur trouvé ");
        }
        return Collections.emptyList();
    }

    /**
     * @return
     */
    @Override
    public List<Utilisateur> getAllFunctionaries() {
        List<Utilisateur> listeFunctionaries =utilisateurRepo.findByRole(Role.ROLE_FONCTIONNAIRE);
        if (!listeFunctionaries.isEmpty()){
            log.info("Liste des utilisateurs trouvé avec succés ");
            return listeFunctionaries;
        }
        else {
            log.warn("Aucun utilisateur trouvé ");
        }
        return Collections.emptyList();
    }
}
