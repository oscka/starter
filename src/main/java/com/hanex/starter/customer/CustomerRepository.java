package com.hanex.starter.customer;

import com.hanex.starter.common.util.jdbc.WithInsert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> , WithInsert<Customer> {
}
