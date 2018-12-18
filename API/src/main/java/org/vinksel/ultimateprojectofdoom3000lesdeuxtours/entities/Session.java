/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vinksel.ultimateprojectofdoom3000lesdeuxtours.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "ID can not be null.")
	@Column(name="session_id")
	private Integer id;
	
	@Column(nullable = false)
	@NotNull(message = "Start date can not be null.")
    private Date start_date;

	@Column(nullable = false)
	@NotNull(message = "End date can not be null.")
    private Date end_date;

	@Column(nullable = false)
	@NotNull(message = "Max number of students can not be null.")
    private Integer max_students;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="course_id")
	@NotNull(message = "A session have to be related to an existing course.")
	private Course course;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="location_id")
	@NotNull(message = "A session need a location.")
	private Location location;

	@ManyToMany(mappedBy = "sessions", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<User> users = new HashSet<User>();
	
	@Transient
	private List students;


	public Session(){};
	
	public void addUser(User user)
	{
		this.users.add(user);
		user.addSession(this);
	}

	public void rmUser(User user)
	{
		user.rmSession(this);
		this.users.remove(user);
	}
	
	public Session(Integer id, Date start_date, Date end_date, Integer max_students, Course course, Location location) {
        this.id = id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.max_students = max_students;
        this.course = course;
        this.location = location;
    }
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	

	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
    }
	public Integer getId()
	{
		return this.id;
	}
	
   public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public void setMax_students(Integer max_students) {
		this.max_students = max_students;
	}

    public Date getStart_date() {
        return start_date;
    }
    
    public Date getEnd_date() {
        return end_date;
    }
	public List getStudents() {
		return this.students;
	}

	public void setStudents(List students) {
		this.students = students;
	}



    public Integer getMax_students() {
        return max_students;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((max_students == null) ? 0 : max_students.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Session other = (Session) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


   
}
