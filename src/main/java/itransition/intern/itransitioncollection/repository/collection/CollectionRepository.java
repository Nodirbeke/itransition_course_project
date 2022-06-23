package itransition.intern.itransitioncollection.repository.collection;

import itransition.intern.itransitioncollection.entity.collection.Collection;
import itransition.intern.itransitioncollection.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CollectionRepository extends JpaRepository<Collection, Long>, BaseRepository {
    @Modifying
    @Query(value = "update Collection set deleted= true where id = :id")
    void softDeleteById(@Param("id") Long id);
}
