package com.NalenWebsite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    private Categories categories;

    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "whatsappLink")
    private String whatsappLink;

    @Column(name = "productImagePath")
    private String imagePath;
}
