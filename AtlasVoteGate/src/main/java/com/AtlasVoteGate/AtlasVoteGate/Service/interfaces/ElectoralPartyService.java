package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;

import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;
import java.util.List;

public interface ElectoralPartyService {
    ElectoralParty addElectoralParty(ElectoralParty party);
    ElectoralParty getElectoralPartyById(Long id);
    List<ElectoralParty> getAllElectoralParties();
    void deleteElectoralParty(Long id);
    // Other electoral party-related methods
}
