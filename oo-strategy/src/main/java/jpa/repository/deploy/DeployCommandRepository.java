package jpa.repository.deploy;

import jpa.domain.deploy.DeployCommand;
import jpa.domain.upms.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface DeployCommandRepository extends JpaRepository<DeployCommand, Integer> {

}
