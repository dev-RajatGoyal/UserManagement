package com.root.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.root.model.Admin;
import com.root.model.User;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	@Query("select a from Admin a where a.username = :username and a.password = :password")
	Optional<Admin> login(@Param("username")String username, @Param("password")String password);
	
}
