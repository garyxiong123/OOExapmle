package jpa.repository;

import jpa.domain.AddressVO;
import jpa.domain.Role;
import jpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @param
     * @return
     */
    List<User> findUsersByRoles(Set<Role> roleList);

    List<User> findUsersByAddressVO(AddressVO addressVO);

    Page<User> findFirstByAddressVO_City(String lastname, Pageable pageable);

    List<User> findUsersByAddressVO_City(String city);

    Optional<List<User>> findOptionalUsersByAddressVO_City(String city);

    @Query("select u from User u where u.username = :username ")
    List<User> findByUsername(@Param("username") String username);

    @Query(value = "select u from User u where u.department = :username ", nativeQuery = true)
    List<User> findByUsername1(@Param("username") String username);


    List<User> findUsersByDepartmentName(String departmentName);

    List<User> findUsersByDepartmentNameAndDepartmentLocation(String departmentName, String location);


}
