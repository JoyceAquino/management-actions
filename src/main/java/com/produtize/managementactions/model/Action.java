package com.produtize.managementactions.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "actions")
public class Action {

    @Id
    private ObjectId Id;
    private String Active;
    private int Quantity;
    private Double BuyPrice;
    private Double SalePrice;
    private Double Variation;

    private Date SaleDate;
    private Date CreatedAt;
    private Date UpdatedAt;

    public enum Currency {BRL, USD}
}
