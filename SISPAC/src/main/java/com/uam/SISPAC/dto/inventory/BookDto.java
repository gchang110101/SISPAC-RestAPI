package com.uam.SISPAC.dto.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDto {
    @JsonProperty("isbn")
    private String idBook;

    private String MFN;
    private String title;
    private Integer existence;
    private String authorId;
    private String classificationId;
}
