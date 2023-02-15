package com.avengers.gamera.dto.user;

import com.avengers.gamera.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserGetDto {
    private long id;
    private Set<Authority> authorities;
    private String name;
    private String email;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
