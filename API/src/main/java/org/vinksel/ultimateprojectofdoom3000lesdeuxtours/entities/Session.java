/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.Date;
import java.util.Objects;
    
public class Session {
	
	private final Integer id;
    private final Date start_date;
    private final Date end_date;
    private final Integer max_students;

    public Session(Integer id, Date start_date, Date end_date, Integer max_students) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.max_students = max_students;
    }

    public Integer getId() {
        return id;
    }

    public Date getStart_date() {
        return start_date;
    }
    
    public Date getEnd_date() {
        return end_date;
    }


    public Integer getMax_students() {
        return max_students;
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
        final Session other = (Session) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.start_date, other.start_date)) {
            return false;
        }
        if (!Objects.equals(this.end_date, other.end_date)) {
            return false;
        }
        if (!Objects.equals(this.max_students, other.max_students)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", start_date=" + start_date + ", end_date=" + end_date + ", max_students=" + max_students + '}';
    }
}
