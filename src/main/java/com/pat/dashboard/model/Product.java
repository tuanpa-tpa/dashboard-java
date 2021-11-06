package com.pat.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_type_id")
    @NotNull
    private Integer productTypeId;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "made_in")
    private String madein;

    @Column(name = "price")
    private float price;

    @Column(name = "id_deleted")
    private Boolean isDeleted;

}
