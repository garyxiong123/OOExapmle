package jpa.repository;

import jpa.domain.Hawk;
import jpa.domain.YellowLing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface YellowLingRepository extends JpaRepository<YellowLing, Integer> {

}
