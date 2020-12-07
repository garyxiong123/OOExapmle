package jpa.repository;

import jpa.domain.User;
import jpa.domain.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {


    List<User> findAllByDiscriminator(UserType discriminator);

}
