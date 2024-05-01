package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;

import com.AtlasVoteGate.AtlasVoteGate.Repository.ElectoralPartyRepo;
import com.AtlasVoteGate.AtlasVoteGate.Repository.UtilisateurRepo;
import com.AtlasVoteGate.AtlasVoteGate.Repository.VoteRepo;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.VoteService;
import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;
import com.AtlasVoteGate.AtlasVoteGate.model.Utilisateur;
import com.AtlasVoteGate.AtlasVoteGate.model.Vote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VoteServiceImp implements VoteService {
    private boolean votingStarted = false;
    private LocalDateTime votingStartTime;
    @Autowired
    private VoteRepo voteRepository;

    @Autowired
    private UtilisateurRepo utilisateurRepository;

    @Autowired
    private ElectoralPartyRepo electoralPartyRepository;
    /**
     * @param idUser
     * @param idParty
     */
    @Override
    public void createVote(Long idUser, Long idParty) {
        // Vérifier si le processus de vote est en cours
        if (!votingStarted) {
            throw new IllegalStateException("Le processus de vote n'a pas encore démarré.");
        }
        // Vérifier si l'utilisateur existe
        Utilisateur user = utilisateurRepository.findById(idUser)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));

        // Vérifier si le parti électoral existe
        ElectoralParty party = electoralPartyRepository.findById(idParty)
                .orElseThrow(() -> new EntityNotFoundException("Parti électoral non trouvé"));

        // Vérifier si l'utilisateur a déjà voté pour ce parti
        boolean hasVotedForParty = voteRepository.existsByUserIdAndElectoralPartyId(idUser, idParty);
        if (hasVotedForParty) {
            throw new IllegalStateException("L'utilisateur a déjà voté pour ce parti.");
        }

        // Créer le vote
        Vote vote = new Vote();
        vote.setUser(user);
        vote.setElectoralParty(party);
        vote.setTimestamp(LocalDateTime.now());

        // Enregistrer le vote dans la base de données
        voteRepository.save(vote);
    }



    /**
     * @param voteId
     * @return
     */
    @Override
    public Vote getVoteById(Long voteId) {
        Optional<Vote> vote= voteRepository.findById(voteId);
        if(vote.isPresent()){
            log.info("vote trouvé avec l ' ID "+ voteId );
            return vote.get();
        }
        else{
            log.warn("Aucun vote trouvé avec l ' ID "+ voteId);
        }
        return null;

    }

    /**
     * @param voteId
     * @param updatedVote
     */
    @Override
    public void updateVote(Long voteId, Vote updatedVote) {
        Optional<Vote> existingVote = voteRepository.findById(voteId);
        if (existingVote.isPresent()) {
            Vote voteToUpdate = existingVote.get();

            // Mettez à jour les propriétés de vote existant avec les nouvelles valeurs
            voteToUpdate.setUser(updatedVote.getUser());
            voteToUpdate.setElectoralParty(updatedVote.getElectoralParty());
            voteToUpdate.setTimestamp(updatedVote.getTimestamp());

            // Sauvegardez le vote mis à jour
            voteRepository.save(voteToUpdate);
        }
        else {
            log.warn("aucun vote existant avec cet ID "+voteId);
        }


    }

    /**
     * @param voteId
     */
    @Override
    public void deleteVote(Long voteId) {
        try {
            voteRepository.deleteById(voteId);
            log.info("vote supprimé avec succés");
        } catch (Exception e) {
            throw new RuntimeException("Error deleting vote: " + e.getMessage(), e);
        }

    }

    /**
     * @return
     */
    @Override
    public List<Vote> getAllVotes() {
        List<Vote> listevotes =voteRepository.findAll();
        if (!listevotes.isEmpty()){
            log.info("Liste des votes trouvé avec succés ");
            return listevotes;
        }
        else {
            log.warn("Aucun vote trouvé ");
        }
        return Collections.emptyList();
    }


    /**
     * @param userId
     * @return
     */
    @Override
    public Vote getVoteByUserId(Long userId) {
        Optional<Vote> vote= voteRepository.findByUserId(userId);
        if(vote.isPresent()){
            log.info("vote trouvé de l' utilsateur avec l ' ID "+ userId );
            return vote.get();
        }
        else{
            log.warn("Aucun vote trouvé de l' utilsateur avec l ' ID "+ userId );
        }
        return null;


    }

    /**
     * @param partyId
     * @return
     */
    @Override
    public long countVotesForElectoralParty(Long partyId) {
        return voteRepository.countByElectoralPartyId(partyId);
    }

    /**
     * @return
     */
    @Override
    public Map<ElectoralParty, Long> countVotesForAllParties() {
        // Récupérer tous les votes
        List<Vote> allVotes = voteRepository.findAll();

        // Regrouper les votes par parti électoral et compter le nombre de votes pour chaque parti
        return allVotes.stream()
                .collect(Collectors.groupingBy(Vote::getElectoralParty, Collectors.counting()));
    }

    /**
     * @return
     */
    @Override
    public ElectoralParty getWinningParty() {
        // Récupérer tous les partis électoraux
        List<ElectoralParty> allParties = electoralPartyRepository.findAll();

        // Trouver le parti avec le plus grand nombre de votes
        Optional<ElectoralParty> winningParty = allParties.stream()
                .max(Comparator.comparingLong(party -> countVotesForElectoralParty(party.getId())));

        // Retourner le parti gagnant s'il existe, sinon null
        return winningParty.orElse(null);
    }

    /**
     *
     */
    @Override
    public void startVotingProcess() {
        // Commencer le processus de vote
        votingStarted = true;
        votingStartTime = LocalDateTime.now();

    }

    /**
     *
     */
    @Override
    public void pauseVotingProcess() {
        // Mettre en pause le processus de vote
        votingStarted = false;

    }

    /**
     *
     */
    @Override
    public void resumeVotingProcess() {
        // Reprendre le processus de vote
        votingStarted = true;

    }

    /**
     * @param newStartTime
     */
    @Override
    public void updateVotingStartTime(LocalDateTime newStartTime) {
        // Mettre à jour l'heure de début du vote
        votingStartTime = newStartTime;

    }


}
