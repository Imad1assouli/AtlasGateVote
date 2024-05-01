package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;

import com.AtlasVoteGate.AtlasVoteGate.Repository.SupportMessageRepo;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.SupportMessageService;
import com.AtlasVoteGate.AtlasVoteGate.model.SupportMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupportMessageServiceImp implements SupportMessageService {
    @Autowired
    SupportMessageRepo supportMessageRepo;
    @Override
    public void saveMessage(Long idVoter, String message) {
        SupportMessage supmess =new SupportMessage(idVoter, message);
        this.supportMessageRepo.save(supmess);



    }

    @Override
    public List<SupportMessage> allSupportMessages() {
        return this.supportMessageRepo.findAll();
    }
}
