package com.uam.SISPAC.dto.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookDto {
    @JsonProperty("isbn")
    private String idBook;
    private String MFN;
    private String title;
    private Integer existence;
    private List<String> authorsId;
    private String classificationId;
    private String publisherId;
}
