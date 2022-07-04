package itransition.intern.itransitioncollection.entity.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Indexed(index = "idx_topics")
public class Topic {

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Field(name = "topic_name", index = Index.YES, store = Store.YES)
    private String name;

}
