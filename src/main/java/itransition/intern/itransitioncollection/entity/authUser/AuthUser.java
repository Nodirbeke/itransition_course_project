package itransition.intern.itransitioncollection.entity.authUser;

import itransition.intern.itransitioncollection.entity.base.Auditable;
import itransition.intern.itransitioncollection.entity.base.BaseEntity;
import itransition.intern.itransitioncollection.entity.collection.Collection;
import itransition.intern.itransitioncollection.entity.item.Comment;
import itransition.intern.itransitioncollection.entity.item.Like;
import itransition.intern.itransitioncollection.enums.AuthRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Indexed(index = "idx_auth_users")
@Where(clause = "deleted is false")
public class AuthUser extends Auditable implements BaseEntity {

    @Field(index = Index.YES, store = Store.YES)
    @Column(nullable = false, unique = true)
    private String username;

    @Column
    @Field(index = Index.YES, store = Store.YES)
    private String fullName;

    @Column
    @Field(index = Index.NO, store = Store.YES)
    private String password;

    @Column(nullable = false, unique = true)
    @Field(index = Index.YES, store = Store.YES)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar default 'USER'")
    @Field(index = Index.YES, store = Store.YES,normalizer = @Normalizer(definition = "lowercase"))
    private AuthRole role;

    @Field(index = Index.NO)
    @Column(columnDefinition = "bool default 'false'")
    private boolean blocked;

    @OneToMany
    @IndexedEmbedded
    private List<Collection> collections;

    @OneToMany
    @IndexedEmbedded
    private List<Like> likes;

    @OneToMany
    @IndexedEmbedded
    private List<Comment> comments;


}
