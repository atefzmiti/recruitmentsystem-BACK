package com.scoremanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.scoremanagment.entities.Condidat;
import com.scoremanagment.entities.DAOUser;


@CrossOrigin(origins="http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="condidat",path="condidat")
public interface CondidatRepository extends JpaRepository<Condidat,Long> {
	Condidat findByUsername(String username);

	

}
