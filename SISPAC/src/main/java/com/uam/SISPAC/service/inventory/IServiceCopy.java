package com.uam.SISPAC.service.inventory;

import com.uam.SISPAC.dto.inventory.CopyDto;
import com.uam.SISPAC.model.inventory.Copy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceCopy {
    public Copy save(CopyDto copy);

    public void deleteById(String id);

    public List<Copy> getCopyByBook(String book);
}
