package com.scoremanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.scoremanagment.entities.Ressource;

@CrossOrigin(origins="http://localhost:4200")
@RepositoryRestResource(collectionResourceRel="ressource",path="ressource")
public interface RessourceRepository extends JpaRepository<Ressource,Long> {

	Ressource findByUsername(String username);

}
