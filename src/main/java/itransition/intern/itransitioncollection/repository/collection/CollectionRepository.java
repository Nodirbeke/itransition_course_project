package itransition.intern.itransitioncollection.repository.collection;

import itransition.intern.itransitioncollection.entity.collection.Collection;
import itransition.intern.itransitioncollection.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CollectionRepository extends JpaRepository<Collection, Long>, BaseRepository {
    @Modifying
    @Query(value = "update Collection " +
            "set deleted= true, " +
            "authUser = concat(authUser,:uuid), " +
            "name = concat(name,:uuid) " +
            "where id = :id")
    void softDeleteById(@Param("id") Long id, @Param("uuid") UUID uuid);


    List<Collection> findCollectionByAuthUser(Long id);
}
