package com.store.car.service;

import com.store.car.model.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostService {

    void newPostDetails(CarPostDto carPostDTO);

    List<CarPostDto> getCarSales();

    void changeCarSale(CarPostDto carPostDTO, Long postId);

    void removeCarSale(Long postId);

}
