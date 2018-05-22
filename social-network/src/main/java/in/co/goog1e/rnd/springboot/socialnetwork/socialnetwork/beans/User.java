package in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private Date dateOfBirth;
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public User() {

	}
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Post> posts;

	/**
	 * @param name
	 * @param dateOfBirth
	 */
	public User(String name, Date dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<Post> getPosts() {
		return posts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name +"]";
	}

}
