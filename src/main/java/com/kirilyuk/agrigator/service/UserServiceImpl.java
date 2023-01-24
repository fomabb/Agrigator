package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.dao.UserDAO;
import com.kirilyuk.agrigator.entities.Product;
import com.kirilyuk.agrigator.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO dao;

    @Autowired
    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Users> getAllUsers() {

        return dao.findAll();
    }

    @Override
    public void deleteProduct(Long id) {

        dao.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {

        dao.deleteAll();
    }
}
