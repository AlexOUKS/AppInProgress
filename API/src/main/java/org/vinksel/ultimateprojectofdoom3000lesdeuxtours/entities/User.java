/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table; 


public class User{
	@NotNull(message = "ID can not be null.")
	private Integer userId;
	@NotNull(message = "Last name can not be null.")
	private String lastname;
	@NotNull(message = "First name can not be null.")
	private String firstname;
	@NotNull(message = "Address can not be null.")
    private String address;
	@NotNull(message = "Phone number can not be null.")
    private String phone;
	@NotNull(message = "Email can not be null.")
    private String courrielElectronique;
	@NotNull(message = "Username can not be null.")
	private String username;
	@NotNull(message = "Password can not be null.")
	private String password;
	
	private String grainsel;
	
	public User() {
		
	}

	public String getGrainsel() {
		return grainsel;
	}

	public void setGrainsel(String grainsel) {
		this.grainsel = grainsel;
	}

	public void setUserId(Integer userId) {
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

	public User(Integer userId, String lastname, String firstname, String address, String phone, String courrielElectronique, String password, String username) {
        this.userId = userId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.courrielElectronique = courrielElectronique;
        this.password = password;
        this.username = username;
    }

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
        final User other = (User) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }
    
}
