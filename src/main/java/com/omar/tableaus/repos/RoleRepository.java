package com.omar.tableaus.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.omar.tableaus.entities.Role;


@RepositoryRestResource(path = "rest")
public interface RoleRepository extends JpaRepository<Role, Long> {

} 
