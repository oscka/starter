package com.hanex.starter.user.domain;

import com.hanex.starter.common.util.jdbc.WithInsert;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> , UserRepositoryCustom , WithInsert<User> {

	Optional<User> findByLoginId(String loginId);

	boolean existsByLoginId(String loginId);
	// existsById

	@Override
	void deleteById(UUID uuid);

	@Override
	void delete(User entity);

	@Modifying
	@Query("""
   			UPDATE user_tb u
   			SET  u.user_name = user.name
   				, u.email = user.email
   				, u.user_password = user.password
   			WHERE id = id
			""")
	boolean changeUserInfo(UUID id,User user);


}
