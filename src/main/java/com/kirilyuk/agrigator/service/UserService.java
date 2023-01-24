package com.kirilyuk.agrigator.service;

import com.kirilyuk.agrigator.entities.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();

    public void deleteProduct(Long id);

    public void deleteAllProducts();
}