## Product backlog
1. Code MVP: Entity, Repository, Service, RestController
- Model (long id, String company, String vacancy, String description, LocalDate sent, Status status)
- map Date and Timestamp with JPA and Hibernate
- automatically add the timestamp using @CreationTimestamp
- format date using @JsonFormat
2. Add DTO
3. Add One-To-Many relationships (Company - Resumes)
4. Add Docker
5. Add Validation to the DTO
6. Add Views using Thymeleaf


## Links
1. [Walls, Craig (2022). Spring in Action, Sixth Edition. Manning Publications. ISBN 9781617297571](https://www.manning.com/books/spring-in-action-sixth-edition)</br>
2. [Документация Spring Data JPA Interface JpaRepository<T,ID>](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)</br>
3. [Spring MVC - should my domain classes implement Serializable for over-the-wire transfer?](https://stackoverflow.com/questions/38457074/spring-mvc-should-my-domain-classes-implement-serializable-for-over-the-wire-t)</br>
4. [LIKE Queries in Spring JPA Repositories](https://www.baeldung.com/spring-jpa-like-queries)</br>
5. [Different between Query keywords Containing, IsContaining, Contains in Spring Data JPA](https://stackoverflow.com/questions/64814957/different-between-query-keywords-containing-iscontaining-contains-in-spring-da)</br>
6. 

