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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "owner_id"}))
public class Collection extends Auditable implements BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private AuthUser ownerId;

    @Column(nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private Topic topicId;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

}
