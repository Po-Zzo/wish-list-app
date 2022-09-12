package com.courtauction.pojo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "coast")
public class Coast {

    @Id
    private String _id;
    private String title;
    private String content;
}
