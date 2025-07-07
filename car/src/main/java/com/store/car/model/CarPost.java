package com.store.car.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "TBL_CAR_POST")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_price")
    private Double price;

    @Column(name = "car_description")
    private String description;

    @Column(name = "car_engine")
    private String engineVersion;

    @Column(name = "car_city")
    private String city;

    @Column(name = "car_created")
    private Date createdDate;

    @Column(name = "car_post_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPost ownerPost;

}
