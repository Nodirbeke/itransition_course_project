package itransition.intern.itransitioncollection.entity.collection;

import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import itransition.intern.itransitioncollection.entity.base.Auditable;
import itransition.intern.itransitioncollection.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "auth_user_id"}))
public class Collection extends Auditable implements BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn
    private AuthUser authUser;

    @Column(nullable = false)
    private String description;

    @OneToOne
    @JoinColumn
    private Topic topic;

    @Column(nullable = false)
    private String imagePath;

}
