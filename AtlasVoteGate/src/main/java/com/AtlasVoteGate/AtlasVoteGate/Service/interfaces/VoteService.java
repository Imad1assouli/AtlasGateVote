package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;

import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;
import com.AtlasVoteGate.AtlasVoteGate.model.Vote;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface VoteService {
    void createVote(Long idUser,Long idParty);
    Vote getVoteById(Long voteId);
    void updateVote(Long voteId, Vote updatedVote);
    void deleteVote(Long voteId);
    List<Vote> getAllVotes();
    Vote getVoteByUserId(Long userId);
    long countVotesForElectoralParty(Long partyId);
    Map<ElectoralParty, Long> countVotesForAllParties();
    ElectoralParty getWinningParty();
    void startVotingProcess();
    void pauseVotingProcess();
    void resumeVotingProcess();
    void updateVotingStartTime(LocalDateTime newStartTime);
    boolean hasVoted(Long idUser);


}
