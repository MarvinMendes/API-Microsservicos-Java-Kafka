package com.store.car.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_OWNER_POST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "owner_type")
    private String type;

    @Column(name = "owner_contact")
    private String contactNumber;


}
