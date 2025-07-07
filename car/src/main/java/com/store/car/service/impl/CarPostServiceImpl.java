package com.store.car.service.impl;

import com.store.car.model.CarPost;
import com.store.car.model.dto.CarPostDto;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import com.store.car.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void newPostDetails(CarPostDto carPostDTO) {
        CarPost carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    @Override
    public List<CarPostDto> getCarSales() {
        List<CarPostDto> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item->{
            listCarsSales.add(mapCarEntityToDTO(item));
        });
        return listCarsSales;
    }

    @Override
    public void changeCarSale(CarPostDto carPostDTO, Long postId) {

        carPostRepository.findById(postId).ifPresentOrElse(item->{
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setModel(carPostDTO.getModel());

            carPostRepository.save(item);

        }, ()-> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPost mapCarDtoToEntity(CarPostDto carPostDTO) {
        CarPost carPostEntity = new CarPost();

        ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(item->{
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContactNumber());
        }, ()-> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setCreatedDate(new Date());

        return carPostEntity;
    }

    private CarPostDto mapCarEntityToDTO(CarPost carPostEntity){

        return CarPostDto.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerPost().getName())
                .price(carPostEntity.getPrice()).build();

    }

}
