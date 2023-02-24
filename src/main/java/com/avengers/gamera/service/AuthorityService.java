package com.avengers.gamera.service;

import com.avengers.gamera.entity.Authority;
import com.avengers.gamera.exception.ResourceNotFoundException;
import com.avengers.gamera.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorityService {

    private final AuthorityRepository authorityRepository;
    public Authority getByAuthorityName(String authorityName) {
        return authorityRepository.findByAuthorityName(authorityName).orElseThrow(() -> new ResourceNotFoundException("Authority", authorityName));

    }
}
