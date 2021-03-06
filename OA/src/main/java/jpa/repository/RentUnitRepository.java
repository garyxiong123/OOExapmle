package jpa.repository;

import jpa.domain.RentUnit;
import jpa.domain.RentUnitContractItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface RentUnitRepository extends JpaRepository<RentUnit, Long> {

}
