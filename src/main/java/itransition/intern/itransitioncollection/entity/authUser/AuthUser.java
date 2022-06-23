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

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted is false")
public class AuthUser extends Auditable implements BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String fullName;

    @Column
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar default 'USER'")
    private AuthRole role;

    @Column(columnDefinition = "bool default 'false'")
    private boolean blocked;

    @OneToMany
    private List<Collection> collections;

    @OneToMany
    private List<Like> likes;

    @OneToMany
    private List<Comment> comments;


}
