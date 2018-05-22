package in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException{
	public PostNotFoundException(String message) {
		super(message);
	}
}
