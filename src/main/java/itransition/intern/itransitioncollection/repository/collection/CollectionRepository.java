package itransition.intern.itransitioncollection.repository.collection;

import itransition.intern.itransitioncollection.entity.collection.Collection;
import itransition.intern.itransitioncollection.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long>, BaseRepository {
}
