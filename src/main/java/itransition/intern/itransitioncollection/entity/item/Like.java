package itransition.intern.itransitioncollection.entity.item;

import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Indexed(index = "idx_likes")
@Table(name = "likes", uniqueConstraints = {@UniqueConstraint(columnNames = {"auth_user_id", "item_id"})})
public class Like {

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ContainedIn
    @ManyToOne(fetch = FetchType.LAZY)
    private AuthUser authUser;

    @JoinColumn
    @ContainedIn
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

}
