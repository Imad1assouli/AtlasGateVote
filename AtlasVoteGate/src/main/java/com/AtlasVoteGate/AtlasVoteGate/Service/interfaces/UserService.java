package com.AtlasVoteGate.AtlasVoteGate.Service.interfaces;

import com.AtlasVoteGate.AtlasVoteGate.model.User;

public interface UserService {
    User registerNewUser(User user);
    User findUserByCne(String cne);
    User verifyUser(Long userId);
    void deleteUser(Long userId);
}
