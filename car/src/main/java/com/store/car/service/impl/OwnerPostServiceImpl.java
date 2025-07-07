package com.store.car.service.impl;

import com.store.car.model.OwnerPost;
import com.store.car.model.dto.OwnerPostDto;
import com.store.car.repository.OwnerPostRepository;
import com.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDto ownerPostDTO) {

        OwnerPost ownerPost = new OwnerPost();
        ownerPost.setName(ownerPostDTO.getName());
        ownerPost.setType(ownerPostDTO.getType());
        ownerPost.setContactNumber(ownerPostDTO.getContactNumber());

        ownerPostRepository.save(ownerPost);

    }

}
