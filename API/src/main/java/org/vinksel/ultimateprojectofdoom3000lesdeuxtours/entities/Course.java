/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.Objects;

import javax.validation.constraints.NotNull; 


public class Course {
	@NotNull(message = "Code can not be null.")
	private String code;

	@NotNull(message = "Title can not be null.")
	private String title;
	@NotNull(message = "description can not be null.")
	private String description;
	
	public Course() {
		
	}

    public Course(String code, String title, String description) {
        this.description = description;
        this.code = code;
        this.title = title;
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
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "description=" + description + ", code=" + code + ", title=" + title + '}';
    }
}
