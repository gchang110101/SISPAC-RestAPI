package com.uam.SISPAC.repository.humanresources;

import com.uam.SISPAC.model.humanresources.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorySystemUser extends JpaRepository<SystemUser, String> {
    @Query("select e from SystemUser e where e.cif = :cif and e.password = :password")
    public SystemUser getSystemUserByCif(@Param("cif") String cif, @Param("password")  String password);
}
