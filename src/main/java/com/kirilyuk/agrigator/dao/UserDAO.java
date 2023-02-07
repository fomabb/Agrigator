package com.kirilyuk.agrigator.dao;

import com.kirilyuk.agrigator.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<Users, Long> {

}