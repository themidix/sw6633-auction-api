package edu.ksu.sw6633auctionapi.repository;

import edu.ksu.sw6633auctionapi.entity.GuestUser;
import edu.ksu.sw6633auctionapi.entity.RegisteredUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestUserRepository extends JpaRepository<GuestUser, Long> {

    @Query(value = "select g from GuestUser as g where g.firstName like %:name% or g.lastName like %:name%")
    Page<GuestUser> findGuestByName(@Param("name") String name, Pageable pageable);

    @Query(value = "select g from GuestUser as g where g.user.email=:email")
    RegisteredUser findGuestUserByEmail(@Param("email") String email);


}
