package com.AtlasVoteGate.AtlasVoteGate.Repository;

import com.AtlasVoteGate.AtlasVoteGate.model.SupportMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportMessageRepo extends JpaRepository<SupportMessage,Long> {

}
