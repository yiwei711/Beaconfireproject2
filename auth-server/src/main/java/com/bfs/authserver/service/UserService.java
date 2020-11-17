package com.bfs.authserver.service;

import com.bfs.authserver.dao.UserDAO;
import com.bfs.authserver.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class UserService{

    private UserDAO userDAO;

    @Autowired
    public void setContactDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public List<User> getAllUsers() {
        return userDAO.getAllUser();
    }
}
