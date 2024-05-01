package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;

import com.AtlasVoteGate.AtlasVoteGate.model.SupportMessage;

import java.util.List;

public interface SupportMessageService {
    public void saveMessage(Long idVoter,String message);

    public List<SupportMessage> allSupportMessages ();
}
