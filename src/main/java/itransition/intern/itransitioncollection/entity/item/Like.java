package itransition.intern.itransitioncollection.entity.item;

import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "likes",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "item_id"})})
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private AuthUser userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    private Item itemId;

}
