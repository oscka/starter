package com.hanex.starter.user.repository;

import com.hanex.starter.common.enums.UserStatus;
import com.hanex.starter.common.util.jdbc.WithInsert;
import com.hanex.starter.user.domain.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> , UserRepositoryCustom , WithInsert<User> {

	Optional<User> findByLoginId(String loginId);

	boolean existsByLoginId(String loginId);

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
	boolean changeUserInfo(@Param("id") UUID id, @Param("user")User user);

	Optional<User> findByIdAndStateIn(UUID uuid, Set<UserStatus> states);

	default Optional<User> findByIdExcludeDeleted(UUID id) {
		return this.findByIdAndStateIn(id, EnumSet.of(UserStatus.ACTIVE, UserStatus.LOCKED,UserStatus.BAN));
	}


}
