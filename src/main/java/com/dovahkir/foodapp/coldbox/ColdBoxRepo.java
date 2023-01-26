package com.dovahkir.foodapp.coldbox;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColdBoxRepo extends CrudRepository<ColdBox,Long> {
}
