package itransition.intern.itransitioncollection.entity.item;

import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import itransition.intern.itransitioncollection.entity.base.Auditable;
import itransition.intern.itransitioncollection.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends Auditable implements BaseEntity {

    private String body;

    @ManyToOne
    @JoinColumn
    private AuthUser authUser;

    @ManyToOne
    @JoinColumn
    private Item item;

}
