package com.uam.SISPAC.dto.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDto {
    private String id;
    private String MFN;
    private String title;
    @JsonProperty("book")
    private String idBook;
}
