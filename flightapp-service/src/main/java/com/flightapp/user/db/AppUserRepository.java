package com.flightapp.user.db;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.user.entity.AppUser;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	Optional<AppUser> findByUserName(String userName);

}
