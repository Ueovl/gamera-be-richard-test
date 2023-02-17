package com.avengers.gamera.entity;

import com.avengers.gamera.constant.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "article")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String coverImgUrl;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Basic
    @Column(nullable = false)
    private String type;

    @Transient
    private ArticleType articleType;

    @Column(nullable = false)
    private boolean isDeleted = false;

    @CreationTimestamp
    private OffsetDateTime createdTime;

    @UpdateTimestamp
    private OffsetDateTime updatedTime;

    @PostLoad
    void fillTransient() {
        if (type != null) {
            this.articleType = ArticleType.of(type);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (articleType != null) {
            this.type = articleType.getTypeName();
        }
    }
}
