package com.uam.SISPAC.dto.inventory;

import com.uam.SISPAC.model.inventory.CopyStatus;
import lombok.Data;

@Data
public class CopyDto {
    private String id;
    private Integer number;

    private String location;

    private CopyStatus copyStatus;

    private String bookId;
}
