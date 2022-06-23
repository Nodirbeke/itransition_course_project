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

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser extends Auditable implements BaseEntity {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "full_name")
    private String fullName;

    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar default 'USER'")
    private AuthRole role;

    @Column(columnDefinition = "bool default false")
    private Boolean blocked;

    @OneToMany
    private List<Collection> collections;

    @OneToMany
    private List<Like> likes;

    @OneToMany
    private List<Comment> comments;


}
