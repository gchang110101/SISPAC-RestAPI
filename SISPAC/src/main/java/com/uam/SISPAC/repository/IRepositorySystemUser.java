package com.uam.SISPAC.repository;

import com.uam.SISPAC.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorySystemUser extends JpaRepository<SystemUser, String> {

}
