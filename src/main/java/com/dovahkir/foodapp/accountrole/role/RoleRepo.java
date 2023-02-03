package com.dovahkir.foodapp.accountrole.role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
