package com.AtlasVoteGate.AtlasVoteGate.controller;

import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.ElectoralPartyService;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.SupportMessageService;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.UtilisateurService;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.VoteService;
import com.AtlasVoteGate.AtlasVoteGate.enums.Role;
import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;
import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;
import com.AtlasVoteGate.AtlasVoteGate.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/voter")

public class VoterController {
    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    ElectoralPartyService electoralPartyService;

    @Autowired
    VoteService voteService;
    @Autowired
    SupportMessageService supportMessageService;

    //fonction pour s'inscrire
    @PostMapping ("/signin")
    public Utilisateur signin (@RequestBody Utilisateur user){
        user.setRole(Role.ROLE_DEMANDEUR);
        return this.utilisateurService.save(user);
    }

    //fonction pour modifier ses infos perso
    @PutMapping("/update/{idUser}")
    public void updateUser(@PathVariable Long idUser ,@RequestBody Utilisateur utilisateur){
        utilisateurService.update(idUser,utilisateur);
    }


    //fonction pour voter
    @PostMapping ("/vote/{idVoter}/{idParty}")
    public void createVote (@PathVariable Long idUser,@PathVariable Long idParty ){
        this.voteService.createVote(idUser, idParty);
    }


    //fonction pour obtenir des infos sur son vote
    @GetMapping ("/voteInfos/{userId}")
    public Vote getVoteInfos (@PathVariable Long userId){
        return this.voteService.getVoteByUserId(userId);
    }


    //fonction pour afficher toutes les party
    @GetMapping ("/partyChoice")
    public List<ElectoralParty> allElectoralParty (){
        return this.electoralPartyService.getAllElectoralParty();
    }


    //fonction pour contacter le support technique
    @PostMapping ("/sendMessage")
    public void contactSupport(@RequestBody String message, @AuthenticationPrincipal UserDetails currentUser) {
        // Obtenez l'identifiant de l'utilisateur actuellement connecté
        Long userId = getUserId(currentUser);

        // Envoyer le message au support technique
        this.supportMessageService.saveMessage(userId,message);

    }

    //Revuperer l Id de l utilisateur deja connecte a l instant
    private Long getUserId(UserDetails currentUser) {
        Utilisateur user = (Utilisateur) currentUser;
        return user.getId();
    }


}
