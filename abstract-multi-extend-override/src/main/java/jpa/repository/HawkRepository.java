package jpa.repository;

import jpa.domain.Animal;
import jpa.domain.Hawk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface HawkRepository extends JpaRepository<Hawk, Integer> {

}
