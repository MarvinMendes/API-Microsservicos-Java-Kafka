package com.portal.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@JsonInclude
@NoArgsConstructor
@AllArgsConstructor
public class CarPostDto {

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private Date createDate = new Date();
    private Long ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;


}
