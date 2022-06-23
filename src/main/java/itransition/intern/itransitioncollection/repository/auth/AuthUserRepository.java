package itransition.intern.itransitioncollection.repository.auth;

import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import itransition.intern.itransitioncollection.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {
    @Modifying
    @Query(value = "update AuthUser " +
            "set deleted = true, " +
            "username = concat(username,:uuid), " +
            "email = concat(email,:uuid) " +
            "where id = :id")
    void softDeleteById(@Param("id") Long id, @Param("uuid") UUID uuid);


    @Query(value = "from AuthUser " +
            "where username = :domain " +
            "or email = :domain")
    Optional<AuthUser> findByUsernameOrEmail(@Param("domain") String domain);
}
