package com.scoremanagment.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class Condidat extends DAOUser {
	
	private int experienceparmois;

	public int getExperienceparmois() {
		return experienceparmois;
	}

	public void setExperienceparmois(int experienceparmois) {
		this.experienceparmois = experienceparmois;
	}

	
}
