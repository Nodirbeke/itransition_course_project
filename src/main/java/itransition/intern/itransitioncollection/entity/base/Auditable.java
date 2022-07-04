package itransition.intern.itransitioncollection.entity.base;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Auditable implements BaseEntity, Serializable {

    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @CreatedBy
    @Field(index = org.hibernate.search.annotations.Index.NO, store = Store.YES)
    private Long createdBy;

    @CreatedDate
    @CreationTimestamp
    @Column(columnDefinition = "timestamp with time zone default now()")
    @Field(index = org.hibernate.search.annotations.Index.NO, store = Store.YES)
    private LocalDateTime createdAt;

    @Column
    @LastModifiedBy
    @Field(index = org.hibernate.search.annotations.Index.NO, store = Store.YES)
    private Long updatedBy;

    @Column
    @UpdateTimestamp
    @LastModifiedDate
    @Field(index = org.hibernate.search.annotations.Index.NO, store = Store.YES)
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "bool default 'false'")
    @Field(index = org.hibernate.search.annotations.Index.NO, store = Store.YES)
    private boolean deleted;

}
