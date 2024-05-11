package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;

import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;

import java.util.List;

public interface ElectoralPartyService {
    ElectoralParty save (ElectoralParty electoralParty);

    void delete (Long idElectoralParty);

    List<ElectoralParty> getAllElectoralParty ();

    ElectoralParty getElectoralParty(Long idElectoralParty);


    void updateElectoralParty (Long idElectoralParty,ElectoralParty electoralParty);

    ElectoralParty getElectoralPartyByNom(String nom);

}
