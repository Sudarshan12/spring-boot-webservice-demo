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

import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.beans.User;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.exceptions.UserNotFoundException;
import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.repository.UserRepository;

@RestController
public class UserResource {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}

	@PostMapping(path="/user")
	public void createUser(@Valid @RequestBody User user) {
		userRepo.save(user);
	}
	@GetMapping(path="/user/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		Optional<User> user =	userRepo.findById(id);
		System.out.println(user);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found "+id);
		}

		return user;
	}

	@DeleteMapping(path="/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		Optional<User> user =	userRepo.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found "+id);
		}
		userRepo.delete(user.get());
	}



}
