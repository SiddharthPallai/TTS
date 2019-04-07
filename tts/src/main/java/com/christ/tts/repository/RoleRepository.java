package com.christ.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christ.tts.model.Role;

/**
 * @author spallai
 *
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRole(String role);
}
