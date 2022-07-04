package itransition.intern.itransitioncollection.entity.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Indexed(index = "idx_tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DocumentId
    private Long id;

    @Field(name = "tag_name", index = Index.NO, store = Store.YES)
    private String name;

    @ManyToMany(mappedBy = "tags")
    @IndexedEmbedded
    private List<Item> item;

}
