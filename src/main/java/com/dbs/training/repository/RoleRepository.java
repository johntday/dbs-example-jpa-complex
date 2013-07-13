package com.dbs.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbs.training.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
