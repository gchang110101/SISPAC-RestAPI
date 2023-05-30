package com.uam.SISPAC.dto.inventory;

import com.uam.SISPAC.model.inventory.CopyStatus;
import lombok.Data;

@Data
public class CopyDto {
    private String location;
    private String bookId;
}
