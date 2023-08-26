package com.searchapi.src.dataloader;

import com.searchapi.src.dbrepo.User;
import com.searchapi.src.dbrepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository){
        this.userRepository = userRepository;
        LoadUsers();
    }

    private void LoadUsers() {
        userRepository.save(new User("Samiylo Kryshu", true));
        userRepository.save(new User("Diesel Jones", true));
    }
}
