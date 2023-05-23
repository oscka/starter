package com.hanex.starter.domain.client;

import com.hanex.starter.common.util.encrypt.EncryptString;
import com.hanex.starter.domain.BaseUser;
import com.hanex.starter.domain.user.common.UserRole;
import com.hanex.starter.domain.user.common.UserState;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(of = "id")
@Builder
@Getter
@ToString
@Table("client")
public class Client {

    @Id
    private Long id;
    private BaseUser baseUser;
    private UserState state;
    private UserRole role;
    private EncryptString email;
    private Group group;
    private String name;
    private String phone;

}
