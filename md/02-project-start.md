1. **H2 console**

```yaml
---
# application.yml
spring:
  profiles:
    active: local
---
# application-local.yml
spring:
  #### h2 ###
  h2:
  console:
    enabled: true
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:starter;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;DEFAULT_NULL_ORDERING=HIGH
    username: sa
    password:
```
application.yml 에서 profile 을 local 로 지정하면 application-local.yml 의 내용이 활성화된다.
브라우저에서 h2-console 접속
- URL : {server-address}**/h2-console**
    - ex) http://localhost:18080/h2-console

2. **API TEST**
- VSCode
    - (httpYac - Rest Client) Extensions 설치
    - http 확장자인 파일 테스트
- IntelliJ
    - Ultimate(유료) 일경우 http 테스트 사용가능

- [User API 테스트](http/users.http)

3. **docker-compose for postgres**
- [postgres Local PC 에서 docker-compose 로 실행](md/etc/docker-compose.yml)

