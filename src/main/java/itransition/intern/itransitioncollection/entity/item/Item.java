package itransition.intern.itransitioncollection.entity.item;

import itransition.intern.itransitioncollection.entity.base.Auditable;
import itransition.intern.itransitioncollection.entity.base.BaseEntity;
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
public class Item extends Auditable implements BaseEntity {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)
    @JoinTable(name = "item_tag",
            joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Comment> comments;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Like> likes;


}
