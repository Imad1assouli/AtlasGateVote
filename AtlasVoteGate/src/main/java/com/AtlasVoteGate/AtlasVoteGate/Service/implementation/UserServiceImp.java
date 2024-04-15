package com.AtlasVoteGate.AtlasVoteGate.Service.implementation;

import com.AtlasVoteGate.AtlasVoteGate.model.User;
import com.AtlasVoteGate.AtlasVoteGate.Repository.UserRepository;
import com.AtlasVoteGate.AtlasVoteGate.Service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    // Constructor-based injection is recommended
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerNewUser(User user) {
        // Implementation for registering a new user
        return userRepository.save(user);
    }

    @Override
    public User findUserByCni(String cni) {
        // Implementation for finding a user by their CNE
        return userRepository.findByCne(cni);
    }

    @Override
    public User verifyUser(Long userId) {
        // Implementation for verifying a user
        // Retrieve user, set verified status, save and return
        return null; // Placeholder for actual implementation
    }

    @Override
    public void deleteUser(Long userId) {
        // Implementation for deleting a user
        userRepository.deleteById(userId);
    }

    // Other necessary user-related methods
}
