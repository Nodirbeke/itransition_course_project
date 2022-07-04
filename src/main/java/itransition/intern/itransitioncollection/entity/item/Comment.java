package itransition.intern.itransitioncollection.entity.item;

import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import itransition.intern.itransitioncollection.entity.base.Auditable;
import itransition.intern.itransitioncollection.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Indexed(index = "idx_comments")
public class Comment extends Auditable implements BaseEntity {

    @Field(store = Store.YES)
    private String body;

    @ManyToOne
    @JoinColumn
    @Field(index = Index.NO, store = Store.YES)
    private AuthUser authUser;

    @ManyToOne
    @JoinColumn
    @IndexedEmbedded
    private Item item;

}
