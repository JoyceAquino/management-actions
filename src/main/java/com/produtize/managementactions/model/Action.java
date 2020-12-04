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
    private ObjectId id;
    private String active;
    private int quantity;
    private Double buyPrice;
    private Double salePrice;
    private Double variation;

    private Date saleDate;
    private Date createdAt;
    private Date updatedAt;

    public enum Currency {BRL, USD}
}
