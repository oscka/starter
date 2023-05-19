package com.hanex.starter.domain.owner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, UUID> {
}
