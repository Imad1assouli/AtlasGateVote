package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;

import com.AtlasVoteGate.AtlasVoteGate.model.Vote;
import com.AtlasVoteGate.AtlasVoteGate.Repository.VoteRepository;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VotingServiceImp implements VotingService {

    private final VoteRepository voteRepository;

    @Autowired
    public VotingServiceImp(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    @Transactional
    public Vote castVote(Vote vote) {
        // Check if the user has already voted if necessary
        // Save the vote
        return voteRepository.save(vote);
    }

    @Override
    public int getTotalVotesForParty(Long partyId) {
        // Aggregate and return the total votes for a specific party
        return voteRepository.countByElectoralPartyId(partyId);
    }

    // Additional methods can be implemented as required.
    // For example, method to check if a user has voted could be useful.
}
