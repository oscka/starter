package com.hanex.starter.domain.client;

import com.hanex.starter.common.util.jdbc.WithInsert;
import com.hanex.starter.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<Client, UUID> , WithInsert<Client> {
}
