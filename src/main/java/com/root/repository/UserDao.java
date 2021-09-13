package com.root.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.root.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>,CrudRepository<User, Integer> {

	@Query("select u from User u where u.username = :username and u.password = :password")
	Optional<User> login(@Param("username")String username, @Param("password")String password);
	
	/*
	 * @Query("select u from User u where u.username = :username") Optional<User>
	 * delete(@Param("username")String username);
	 */
	@Query("select u from User u where u.username = :username")
	public User findByUsername(@Param("username") String username);
}
