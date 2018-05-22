package in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.goog1e.rnd.springboot.socialnetwork.socialnetwork.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
