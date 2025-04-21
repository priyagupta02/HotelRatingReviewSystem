package com.lcwd.user.service.repositories;

import com.lcwd.user.service.entities.User; // ✅ Correct!

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepositories extends JpaRepository<User, String>
{
    //if you want to implement any custom method or query
}
