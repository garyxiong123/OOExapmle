package jpa.repository;

import jpa.domain.Address;
import jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
