package com.store.car.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@JsonInclude
@NoArgsConstructor
@AllArgsConstructor
public class CarPostDto {

    private String model;
    private String brand;
    private String price;
    private String description;
    private String engineVersion;
    private String city;
    private String createDate;
    private Long ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;


}
