package com.crm.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crm.Models.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer> {
	
	Users findByEmail(String email);

}
