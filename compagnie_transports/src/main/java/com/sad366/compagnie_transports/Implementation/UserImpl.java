package com.sad366.compagnie_transports.Implementation;

import com.sad366.compagnie_transports.Methodes.UserMethode;
import com.sad366.compagnie_transports.Repositories.UserRepo;
import com.sad366.compagnie_transports.Tables.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserImpl implements UserMethode {

    private final UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User upateUser(Long id, User user) {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouve"));

        existingUser.setNom_prenom_user(user.getNom_prenom_user());
        existingUser.setNumCNI_user(user.getNumCNI_user());
        existingUser.setEmail_user(user.getEmail_user());
        existingUser.setTelephone_user(user.getTelephone_user());
        existingUser.setProfession_user(user.getProfession_user());
        existingUser.setPassword_user(user.getPassword_user());

        return userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
