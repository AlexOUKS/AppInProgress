/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class Location {

	@NotNull(message = "ID can not be null.")
	private Integer id;
	@NotNull(message = "City name can not be null.")
    private String city;

    public Location(Integer id, String city) {
        this.id = id;
        this.city = city;
    }
    
    public void setId(Integer id) {
		this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
		this.city = city;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", city=" + city + '}';
    }
    
}
