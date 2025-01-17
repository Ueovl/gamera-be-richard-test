package com.avengers.gamera.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String platform;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column
    private String country;

    @Column
    private Double scores;

    @Column
    private String developers;

    @Column
    private String publishers;

    @Column
    private String introduction;

    @Column
    private String description;

    @Column(name = "is_deleted")
    @Builder.Default
    private Boolean isDeleted = false;

    @Column(name = "created_time")
    @CreationTimestamp
    private OffsetDateTime createdTime;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private OffsetDateTime updatedTime;

}
