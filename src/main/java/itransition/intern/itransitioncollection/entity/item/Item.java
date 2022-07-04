package itransition.intern.itransitioncollection.entity.item;

import itransition.intern.itransitioncollection.entity.base.Auditable;
import itransition.intern.itransitioncollection.entity.base.BaseEntity;
import itransition.intern.itransitioncollection.entity.collection.Collection;
import itransition.intern.itransitioncollection.utils.Varchar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Indexed(index = "idx_items")
public class Item extends Auditable implements BaseEntity {


    @Column
    @Field(name = "item_name", store = Store.YES)
    private String name;

    @ManyToOne
    @IndexedEmbedded
    private Collection collection;

    @ContainedIn
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "item_tag",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private List<Tag> tags;

    @ContainedIn
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @IndexedEmbedded
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes;

    @ElementCollection
    @Field(store = Store.YES)
    @MapKeyColumn(name = "name")
    @CollectionTable(name = "integer_values_mapping",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Map<String, Integer> integerValues;

    @ElementCollection
    @Field(store = Store.YES)
    @MapKeyColumn(name = "name")
    @CollectionTable(name = "varchar_values_mapping",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Map<String, Varchar> varcharValues;

    @ElementCollection
    @Field(store = Store.YES)
    @MapKeyColumn(name = "name")
    @CollectionTable(name = "text_values_mapping",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Map<String, String> textValues;

    @ElementCollection
    @Field(store = Store.YES)
    @MapKeyColumn(name = "name")
    @CollectionTable(name = "boolean_values_mapping",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Map<String, Boolean> booleanValues;

    @ElementCollection
    @Field(store = Store.YES)
    @MapKeyColumn(name = "name")
    @CollectionTable(name = "date_values_mapping",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private Map<Integer, Date> dateValues;


}
