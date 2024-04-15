package com.AtlasVoteGate.AtlasVoteGate.controller;

import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.ElectoralPartyService;
import com.AtlasVoteGate.AtlasVoteGate.dto.ElectoralPartyDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/electoralparties")
@CrossOrigin("*")
public class ElectoralPartyController {
    private ElectoralPartyService electoralpartyService;

    @GetMapping("/all")
    public List<ElectoralPartyDTO> getAllElectoralParties() { return electoralpartyService.getAllElectoralParties(); }

    @GetMapping("/{id}")
    public ElectoralPartyDTO getElectoralParty(@PathVariable Long id){
        return electoralpartyService.getElectoralPartyById(id);
    }

    @GetMapping("/{name}")
    public ElectoralPartyDTO getElectoralPartyByName(@PathVariable String name){
        return electoralpartyService.getElectoralPartyByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteElectoralParty(@PathVariable Long id){
        electoralpartyService.deleteElectoralPartyById(id);
    }

    @PutMapping("/edit/{id}")
    public ElectoralPartyDTO editElectoralParty(@PathVariable Long id, @RequestBody ElectoralPartyDTO electoralparty){
        electoralparty.setId(id);
        return electoralpartyService.updateElectoralParty(id, electoralparty);
    }

    @PostMapping("/new-electoralparty")
    public ElectoralPartyDTO newAppointment(@RequestBody ElectoralPartyDTO electoralparty){
        return electoralpartyService.createElectoralParty(electoralparty);
    }
}
