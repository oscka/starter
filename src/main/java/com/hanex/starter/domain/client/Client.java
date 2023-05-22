package com.hanex.starter.domain.client;

import com.hanex.starter.domain.BaseUser;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode(of = "id")
@Builder
@Getter
@ToString
@Table("tb_client")
public class Client {

    private BaseUser baseUser;
    private Group group;

}
