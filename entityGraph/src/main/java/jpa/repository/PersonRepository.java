package jpa.repository;

import jpa.domain.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @EntityGraph(value = "person.all", type = EntityGraph.EntityGraphType.FETCH)
    Person findById(String id);


}
