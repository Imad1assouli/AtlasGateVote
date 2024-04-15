package com.AtlasVoteGate.AtlasVoteGate.mappers.electoralparty;

import com.AtlasVoteGate.AtlasVoteGate.dto.ElectoralPartyDTO;
import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;

public interface ElectoralPartyMapper {
    ElectoralPartyDTO fromElectoralParty(ElectoralParty electoralParty);
    ElectoralParty fromElectoralPartyDTO(ElectoralPartyDTO electoralPartyDTO);
}
