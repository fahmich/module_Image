package com.goldenkey.module2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhotoRepository extends CrudRepository<PhotoDTO, Integer> {
	
}
