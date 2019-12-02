package jpa.repository;

import jpa.domain.Role;
import jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findRolesByRoleName(String roleName);
}
