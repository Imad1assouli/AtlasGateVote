package com.AtlasVoteGate.AtlasVoteGate.Repository;

import com.AtlasVoteGate.AtlasVoteGate.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepo extends JpaRepository<Vote,Long> {
    boolean existsByUserIdAndElectoralPartyId(Long userId, Long partyId);
    boolean existsByUserId(Long userId);
    int countByElectoralPartyId(Long partyId);


    Optional<Vote> findByUserId(Long userId);

}
