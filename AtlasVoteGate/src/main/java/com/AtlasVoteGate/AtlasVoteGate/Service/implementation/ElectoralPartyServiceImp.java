package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;

import com.AtlasVoteGate.AtlasVoteGate.Repository.ElectoralPartyRepo;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.ElectoralPartyService;
import com.AtlasVoteGate.AtlasVoteGate.model.ElectoralParty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class ElectoralPartyServiceImp implements ElectoralPartyService {

    private ElectoralPartyRepo electoralPartyRepo;

    public ElectoralPartyServiceImp(ElectoralPartyRepo electoralPartyRepo){
        this.electoralPartyRepo=electoralPartyRepo;
    }

    @Override
    public ElectoralParty save(ElectoralParty electoralParty) {
        this.electoralPartyRepo.save(electoralParty);
        log.info("Electoral Party saved successfully");
        return electoralParty;
    }

    @Override
    public void delete(Long idElectoralParty) {
        this.electoralPartyRepo.deleteById(idElectoralParty);
        log.info("Electoral Party deleted successfully");

    }

    @Override
    public List<ElectoralParty> getAllElectoralParty() {
        return this.electoralPartyRepo.findAll();
    }

    @Override
    public ElectoralParty getElectoralParty(Long idElectoralParty) {
        Optional<ElectoralParty> electoralParty= this.electoralPartyRepo.findById(idElectoralParty);
        if(electoralParty.isPresent()){
            log.info("Electoral Party found successfully with id"+idElectoralParty);
            return electoralParty.get();
        }
        log.info("There is no Electoral Party with id"+idElectoralParty);
        return null;
    }

    @Override
    public void update(Long idElectoralParty, ElectoralParty newelectoralParty) {
       Optional<ElectoralParty> electoralPartyOptional = this.electoralPartyRepo.findById(idElectoralParty);
        if(electoralPartyOptional.isPresent()){
            ElectoralParty oldElectoralParty =electoralPartyOptional.get();
            oldElectoralParty.setName(newelectoralParty.getName());
            oldElectoralParty.setDescription(newelectoralParty.getDescription());

            this.electoralPartyRepo.save(oldElectoralParty);
            log.info("Electoral Party updated successfully");
        }
        else{
            log.info("There is no Electoral Party with id"+idElectoralParty);
        }

    }


    @Override
    public ElectoralParty getElectoralPartyByNom(String nom) {
       Optional<ElectoralParty> electoralParty= this.electoralPartyRepo.findByName(nom);
        if(electoralParty.isPresent()){
            log.info("Electoral Party found successfully with name"+nom);
            return electoralParty.get();
        }
        log.info("There is no Electoral Party with name"+nom);
        return null;
    }
}
