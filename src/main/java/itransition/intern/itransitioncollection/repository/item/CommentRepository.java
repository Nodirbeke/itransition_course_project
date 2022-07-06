package itransition.intern.itransitioncollection.repository.item;

import itransition.intern.itransitioncollection.entity.item.Comment;
import itransition.intern.itransitioncollection.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.ValidationAnnotationUtils;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, BaseRepository {

    @Modifying
    @Query(value = "update Comment set deleted = true where id = :id")
    void softDeleteById(@Param("id") Long id);


    List<Comment> findAllByItemId(Long id);


}
