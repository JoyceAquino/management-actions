package com.produtize.managementactions.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "actions")
public class Action {

    @Id
    private ObjectId id;
    private String active;
    private int quantity;
    private Double buyPrice;
    private Double salePrice;
    private Double variation;

    private LocalDate saleDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Currency currency;

    public enum Currency {BRL, USD}
}
