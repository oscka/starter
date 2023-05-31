package com.hanex.starter.user.repository;

import com.hanex.starter.user.domain.User;

import java.util.UUID;

public interface UserRepositoryCustom {

    void deleteById(UUID id);

    void delete(User entity);
}
