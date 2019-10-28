package jpa.repository;

import jpa.domain.Contract;
import jpa.domain.RentUnitContractItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface ContractRepository extends JpaRepository<Contract, Long> {

}
