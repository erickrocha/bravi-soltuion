package com.erocha.person.gateways.repository;

import com.erocha.person.domains.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {

    @Query("SELECT p FROM Person p JOIN p.contacts c WHERE p.name like :name or p.identityDocument = :identityDocument or c.value = :contact or p.dateBirth = :dateBirth")
    Page<Person> findByNameOrIdentityDocumentOrEmailOrDateBirth(
            @Param("name") String name,
            @Param("identityDocument") String identityDocument,
            @Param("contact") String contact,
            @Param("dateBirth") LocalDate dateBirth, Pageable pageRequest);

}
