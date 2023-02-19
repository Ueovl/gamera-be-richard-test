package com.avengers.gamera.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String platform;

    @Column(nullable = false)
    private Date release_date;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer scores;
    @Column(nullable = false)
    private String developers;
    @Column(nullable = false)
    private String publishers;
    @Column(nullable = false)
    private String introduction;
    @Column(nullable = false)
    private String description;
    @Column()
    @Builder.Default
    private Boolean is_deleted=false;

    @CreationTimestamp
    private OffsetDateTime created_time;

    @UpdateTimestamp
    private OffsetDateTime updated_time;

}
