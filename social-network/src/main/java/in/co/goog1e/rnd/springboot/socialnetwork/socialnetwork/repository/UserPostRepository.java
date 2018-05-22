package in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.beans.Post;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.beans.User;

@Repository
public interface UserPostRepository extends JpaRepository<Post, User>{
	public List<Post> findByUser_Id(Long id); 
}
