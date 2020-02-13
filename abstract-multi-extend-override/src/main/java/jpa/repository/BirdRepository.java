package jpa.repository;

import jpa.domain.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface BirdRepository extends JpaRepository<Bird, Integer> {

}
