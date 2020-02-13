package jpa.repository;

import jpa.override.Person;
import jpa.override.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
