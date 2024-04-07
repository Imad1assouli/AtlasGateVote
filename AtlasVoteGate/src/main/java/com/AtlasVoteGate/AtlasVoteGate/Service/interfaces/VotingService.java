package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;

import com.AtlasVoteGate.AtlasVoteGate.model.Vote;

public interface VotingService {
    Vote castVote(Vote vote);
    int getTotalVotesForParty(Long partyId);
    // Other voting-related methods
}
