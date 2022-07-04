package itransition.intern.itransitioncollection.repository.item;

import itransition.intern.itransitioncollection.entity.item.Item;
import itransition.intern.itransitioncollection.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends  JpaRepository<Item, Long>, BaseRepository {
}
