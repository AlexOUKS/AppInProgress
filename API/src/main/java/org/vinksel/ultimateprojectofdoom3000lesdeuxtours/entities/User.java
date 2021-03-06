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

import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicUpdate; 

@Entity
@DynamicUpdate
public class User{
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(nullable = false)
	@NotNull(message = "Last name can not be null.")
	private String lastname;



	@Column(nullable = false)
	@NotNull(message = "First name can not be null.")
	private String firstname;

	@Column(nullable = false)
	@NotNull(message = "Address can not be null.")
    private String address;

	@Column(nullable = false)
	@NotNull(message = "Phone number can not be null.")
    private String phone;

	@Column(nullable = false, name="email")
	@NotNull(message = "Email can not be null.")
    private String courrielElectronique;

	@Column(nullable = false)
	@NotNull(message = "Username can not be null.")
	private String username;

	@Column(nullable = false)
	@NotNull(message = "Password can not be null.")
	private String password;

	@Column(nullable = false)
	@NotNull(message = "Saltkey can not be null.")
	private String grainsel;
	
	@Column(nullable = false)
	@NotNull(message = "Token can not be null.")
	private String token;
	
	
	@ManyToMany(targetEntity = Session.class, fetch = FetchType.EAGER)
	@JoinTable(name="User_Session", joinColumns= @JoinColumn(name="user_id", referencedColumnName = "user_id"),
				inverseJoinColumns = @JoinColumn(name ="session_id", referencedColumnName = "session_id"))
	private Set<Session> sessions =  new HashSet<Session>();

	public User() {}

	public String getGrainsel() {
		return grainsel;
	}
	
	public void addSession(Session session)
	{
		this.sessions.add(session);
	}

	public void setGrainsel(String grainsel) {
		this.grainsel = grainsel;
	}

	@SuppressWarnings("unused")
	private void setUserId(Integer userId) {
		this.userId = userId;
    }
	
    public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCourrielElectronique(String courrielElectronique) {
		this.courrielElectronique = courrielElectronique;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer userId, String lastname, String firstname, String address, String phone, String courrielElectronique, String password, String username, String token) {
        this.userId = userId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.courrielElectronique = courrielElectronique;
        this.password = password;
        this.username = username;
        this.token = token;
    }

    @SuppressWarnings("unused")
	public Integer getUserId() {
        return userId;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }


    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }

    public String getCourrielElectronique() {
        return courrielElectronique;
    }


    public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((courrielElectronique == null) ? 0 : courrielElectronique.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((grainsel == null) ? 0 : grainsel.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public void rmSession(Session session) {
		this.sessions.remove(session);
	}
    
}
