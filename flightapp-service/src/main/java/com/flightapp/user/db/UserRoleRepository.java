package com.flightapp.user.db;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.user.entity.UserRole;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
