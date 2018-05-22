package in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user; 
	Post(){

	}

	/**
	 * @param title
	 * @param description
	 * @param postedBy
	 */
	public Post(String title, String description) {
		this.title = title;
		this.description = description;
		//this.user = postedBy;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	/*public User getPostedBy() {
		return user;
	}*/
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", postedBy=" + "]";
	}

}
