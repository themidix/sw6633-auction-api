package edu.ksu.sw6633auctionapi.repository;

import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {

    @Query(value = "select r from RegisteredUser as r where r.firstName like %:name% or r.lastName like %:name%")
    Page<RegisteredUser> findRegisteredUserByName(@Param("name") String name, Pageable pageable);

    @Query(value = "select r from RegisteredUser as r where r.user.email=:email")
    RegisteredUser findRegisteredUserByEmail(@Param("email") String email);
}
