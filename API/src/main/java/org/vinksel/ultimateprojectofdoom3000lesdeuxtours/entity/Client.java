/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity;

import java.util.Objects; 

public class Client{
	private final Integer id;
	private final String lastname;
	private final String firstname;
    private final String address;
    private final String phone;
    private final String courrielElectronique;
    private final Account account;

    public Client(Integer id, String lastname, String firstname, String address, String phone, String courrielElectronique, Account account) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.courrielElectronique = courrielElectronique;
        this.account = account;
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


    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", phone=" + phone + ", courrielElectronique=" + courrielElectronique + ", account=" + account + '}';
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
