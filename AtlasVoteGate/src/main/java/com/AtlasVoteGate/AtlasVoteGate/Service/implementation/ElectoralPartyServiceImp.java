package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;

import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;
import com.AtlasVoteGate.AtlasVoteGate.Repository.ElectoralPartyRepository;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.ElectoralPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectoralPartyServiceImp implements ElectoralPartyService {

    private final ElectoralPartyRepository electoralPartyRepository;

    @Autowired
    public ElectoralPartyServiceImp(ElectoralPartyRepository electoralPartyRepository) {
        this.electoralPartyRepository = electoralPartyRepository;
    }

    @Override
    public ElectoralParty addElectoralParty(ElectoralParty party) {
        // Before saving, you might want to include checks to prevent duplicates or validate data.
        return electoralPartyRepository.save(party);
    }

    @Override
    public ElectoralParty getElectoralPartyById(Long id) {
        Optional<ElectoralParty> electoralParty = electoralPartyRepository.findById(id);
        if (electoralParty.isPresent()) {
            return electoralParty.get();
        } else {
            // Handle the case where the electoral party is not found.
            // This could be by throwing an exception or returning null.
            return null;
        }
    }

    @Override
    public List<ElectoralParty> getAllElectoralParties() {
        return electoralPartyRepository.findAll();
    }

    @Override
    public void deleteElectoralParty(Long id) {
        electoralPartyRepository.deleteById(id);
        // You may want to handle the case where the electoral party does not exist.
    }

    // You may implement other methods required by your application logic.
    // For example, updating electoral party information, etc.
}
