package com.hanex.starter.customer.repository;

import com.hanex.starter.common.enums.Group;
import com.hanex.starter.customer.domain.Customer;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> , CustomerRepositoryCustom{

    // TODO baseUser 찾는 방법 > loginId 중복 검사 필요
    //Optional<Customer> findByBaseUser(String loginId);

    @Modifying
    @Query(
        """
            UPDATE customer
            SET email = :email
                , group = :group
                , name = :name
                , phone = :phone
                , memo = :memo
        """
    )
    boolean changeCustomer(@Param("email") String email
                            , @Param("group") Group group
                            , @Param("name") String name
                            , @Param("phone") String phone
                           , @Param("memo") String memo
                        );
}
