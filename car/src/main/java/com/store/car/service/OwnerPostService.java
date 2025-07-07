package com.store.car.service;

import com.store.car.model.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {
    void createOwnerPost(OwnerPostDto ownerPostDTO);
}
