package com.neidev.store.product.entity;

import com.neidev.store.product.json.ProductResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "PRODUCT")
@Table(name = "TB_PRODUCT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.UUIDGenerator"
    )
    private String id;
    @Column(nullable = false, unique = true)
    private String productName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String shortDescription;
    @Column(nullable = false, unique = true)
    private String imgUrl;
    @Column(nullable = false)
    private BigDecimal price;

    public ProductResponse toResponse() {
        return ProductResponse.builder()
                .id(getId())
                .productName(getProductName())
                .shortDescription(getShortDescription())
                .price(getPrice())
                .build();
    }

}
