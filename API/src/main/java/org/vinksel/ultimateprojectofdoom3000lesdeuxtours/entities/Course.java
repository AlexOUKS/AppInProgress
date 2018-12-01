/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.vinksel.ultimateprojectofdoom3000lesdeuxtours.repositories.SessionRepository;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
@Table(name="course")
public class Course {
	@Id
	@NotNull(message = "Code can not be null.")
	private String code;

	@Column(nullable=false) 
	@NotNull(message = "Title can not be null.")
	private String title;

	@Column(nullable=false) 
	@NotNull(message = "description can not be null.")
	private String description;
	
	//Toute modification de l'attr. course d'une Session modifiera la liste des sessions du-dit objet course
	@OneToMany(mappedBy="course", fetch = FetchType.EAGER)
	private Set<Session> sessions = new HashSet<Session>();

	public Course(){};
	
    public Course(String code, String title, String description) {
        this.description = description;
        this.code = code;
        this.title = title;
        this.sessions = new HashSet<Session>();
    }

    public Course(String code, String title, String description, Set<Session> sessions) {
        this.description = description;
        this.code = code;
        this.title = title;
        this.sessions = sessions;
    }

    public Set<Session> getSessions() {
		return sessions;
	}

	@SuppressWarnings("unused")
	private void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	
	public void addSession(Session session)
	{
		session.setCourse(this);
		this.sessions.add(session);
	}
	
	public void removeSession(Session session) throws Exception{
		SessionRepository.getInstance().remove(session.getId());
		this.sessions.remove(session);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }
    
    public String getTitle() {
        return title;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Course other = (Course) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

    @Override
	public String toString() {
		return "Course [code=" + code + ", title=" + title + ", description=" + description +
				"]";
	}
}
