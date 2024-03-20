package com.AtlasVoteGate.AtlasVoteGate.Repository;

import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectoralPartyRepo extends JpaRepository<ElectoralParty,Long> {
    Optional<ElectoralParty> findByName (String name);
}
