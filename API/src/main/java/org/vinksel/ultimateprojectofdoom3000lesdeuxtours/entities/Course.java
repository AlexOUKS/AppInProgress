/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.Objects;

import javax.validation.constraints.NotNull; 
public class Course{

	@NotNull(message = "Title can not be null.")
	private final String title;
	@NotNull(message = "ID can not be null.")
	private final Integer id;
	@NotNull(message = "Code can not be null.")
	private final String code;

    public Course(Integer id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
    
    public String getTitle() {
        return title;
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", code=" + code + ", title=" + title + '}';
    }
    
    
    
    
}
