package com.uam.SISPAC.repository.humanresources;

import com.uam.SISPAC.model.humanresources.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorySystemUser extends JpaRepository<SystemUser, String> {

}
