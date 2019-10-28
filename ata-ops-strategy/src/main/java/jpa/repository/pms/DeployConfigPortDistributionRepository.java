package jpa.repository.pms;

import jpa.domain.pms.App;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface DeployConfigPortDistributionRepository extends JpaRepository<App, Integer> {

}
