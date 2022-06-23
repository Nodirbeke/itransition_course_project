package itransition.intern.itransitioncollection.entity.base;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @CreatedBy
    private Long createdBy;

    @CreatedDate
    @CreationTimestamp
    @Column(columnDefinition = "timestamp with time zone default now()")
    private LocalDateTime createdAt;

    @Column
    @LastModifiedBy
    private Long updatedBy;

    @Column
    @UpdateTimestamp
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "bool default 'false'")
    private boolean deleted;

}
