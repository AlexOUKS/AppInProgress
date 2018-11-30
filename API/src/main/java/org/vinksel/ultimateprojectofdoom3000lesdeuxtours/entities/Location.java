/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "ID can not be null.")
	@Column(name="location_id")
	private Integer id;
	
	@Column(nullable=false) 
	@NotNull(message = "City name can not be null.")
    private String city;

	@OneToMany(mappedBy="location")
	private Set<Session> sessions = new HashSet<Session>();
	
    public Location(Integer id, String city) {
        this.id = id;
        this.city = city;
    }
    
    private void setId(Integer id) {
		this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
		this.city = city;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		return true;
	}

    @Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", sessions=" + sessions + "]";
	}
    
}
