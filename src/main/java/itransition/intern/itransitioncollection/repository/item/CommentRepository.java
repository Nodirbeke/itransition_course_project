package itransition.intern.itransitioncollection.repository.item;

import itransition.intern.itransitioncollection.entity.item.Comment;
import itransition.intern.itransitioncollection.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, BaseRepository {
}
