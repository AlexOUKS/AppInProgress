/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author nvince01
 */
public class CourseSession implements Serializable {
    private Integer id;
    private Date start_date;
    private Date end_date;
    private Integer max_students;

    public CourseSession(Integer id, Date start_date, Date end_date, Integer max_students) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.max_students = max_students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Integer getMax_students() {
        return max_students;
    }

    public void setMax_students(Integer max_students) {
        this.max_students = max_students;
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
        final CourseSession other = (CourseSession) obj;
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
