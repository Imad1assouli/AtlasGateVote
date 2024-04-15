package com.AtlasVoteGate.AtlasVoteGate.mappers.electoralparty;

import com.AtlasVoteGate.AtlasVoteGate.dto.ElectoralPartyDTO;
import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;
import org.springframework.beans.BeanUtils;

public class ElectoralPartyMapperImp implements ElectoralPartyMapper {
    @Override
    public ElectoralPartyDTO fromElectoralParty(ElectoralParty electoralParty) {
        ElectoralPartyDTO electoralPartyDTO = new ElectoralPartyDTO();
        BeanUtils.copyProperties(electoralParty, electoralPartyDTO);
        return electoralPartyDTO;
    }

    @Override
    public ElectoralParty fromElectoralPartyDTO(ElectoralPartyDTO electoralPartyDTO) {
        ElectoralParty electoralParty = new ElectoralParty();
        BeanUtils.copyProperties(electoralPartyDTO, electoralParty);
        return electoralParty;
    }
}
