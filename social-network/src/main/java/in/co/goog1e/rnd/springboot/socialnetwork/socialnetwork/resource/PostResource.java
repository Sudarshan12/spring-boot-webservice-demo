package in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.beans.Post;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.beans.User;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.exceptions.PostNotFoundException;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.exceptions.UserNotFoundException;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.repository.PostRepository;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.repository.UserPostRepository;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.repository.UserRepository;

@RestController
public class PostResource {
	@Autowired
	private PostRepository postRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserPostRepository userPostRepo;

	@PostMapping(path="/user/{userId}/post")
	public void createPost(@PathVariable Long userId,@Valid @RequestBody Post post) {
		Optional<User> user = userRepo.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("Can't post for the user who doesn't exist");
		}
		//post.setUser(user.get());
		post.setUser(user.get());
		postRepo.save(post);
	}
	@GetMapping(path="/user/{id}/posts")
	public List<Post> getAllPosts(@PathVariable Long id) {
		Optional<User> user = userRepo.findById(id);
		System.out.println(user);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found "+id);
		}

		return userPostRepo.findByUser_Id(id); 
	}
	@GetMapping(path="/user/{userId}/post/{postId}")
	public Post getOnePost(@PathVariable Long postId,@PathVariable Long userId) {
		Optional<Post> post = postRepo.findById(postId);
		if(!post.isPresent()) {
			throw new PostNotFoundException("Post not found for the user");
		}
		if(post.get().getUser().getId()!=userId) {
			throw new PostNotFoundException("Post not found for the user");
		}
		return post.get();
	}
	@DeleteMapping(path="/user/{userId}/post/{postId}")
	public void deletePost(@PathVariable Long userId,@PathVariable Long postId) {
		Optional<User> user = userRepo.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("user not found");
		}
		Optional<Post> post = postRepo.findById(postId);
		if(!post.isPresent()) {
			throw new PostNotFoundException("Post not found");
		}
		if(post.get().getUser().getId()!=userId) {
			throw new PostNotFoundException("Post Not found");
		}
		postRepo.deleteById(postId);
	}

}
