/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.Objects;

import javax.validation.constraints.NotNull; 

public class User{
	@NotNull(message = "ID can not be null.")
	private final Integer id;
	@NotNull(message = "Last name can not be null.")
	private final String lastname;
	@NotNull(message = "First name can not be null.")
	private final String firstname;
	@NotNull(message = "Address can not be null.")
    private final String address;
	@NotNull(message = "Phone number can not be null.")
    private final String phone;
	@NotNull(message = "Email can not be null.")
    private final String courrielElectronique;
	@NotNull(message = "Username can not be null.")
	private final String username;
	@NotNull(message = "Password can not be null.")
	private final String password;

    public User(Integer id, String lastname, String firstname, String address, String phone, String courrielElectronique, String password, String username) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.courrielElectronique = courrielElectronique;
        this.password = password;
        this.username = username;
    }

    public Integer getId() {
        return id;
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
