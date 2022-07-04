package itransition.intern.itransitioncollection.entity.collection;

import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import itransition.intern.itransitioncollection.entity.base.Auditable;
import itransition.intern.itransitioncollection.entity.base.BaseEntity;
import itransition.intern.itransitioncollection.entity.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Indexed(index = "idx_collections")
@Where(clause = "deleted is false")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "auth_user_id"}))
public class Collection extends Auditable implements BaseEntity {



    @Column(nullable = false)
    @Field(name = "collection_name")
    private String name;

    @ManyToOne
    @JoinColumn
    @ContainedIn
    private AuthUser authUser;

    @OneToMany
    @ContainedIn
    private List<Item> item;

    @Field
    @Column(nullable = false)
    private String description;

    @Field
    @OneToOne
    @JoinColumn
    private Topic topic;

    @Field(index = Index.NO, store = Store.YES)
    @Column(nullable = false)
    private String imagePath;

}
