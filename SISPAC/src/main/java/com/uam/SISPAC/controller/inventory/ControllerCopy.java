package com.uam.SISPAC.controller.inventory;

import com.uam.SISPAC.dto.inventory.CopyDto;
import com.uam.SISPAC.model.inventory.Copy;
import com.uam.SISPAC.service.inventory.IServiceCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copy")
public class ControllerCopy {

    @Qualifier("ServiceCopy")
    @Autowired
    IServiceCopy serviceCopy;

    @GetMapping("/allByBook")
    public List<Copy> copies(@Param("book") String book) {
        return serviceCopy.getCopyByBook(book);
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable String id) {
        serviceCopy.deleteById(id);
    }

    @PutMapping("/update")
    public Copy update(@RequestBody CopyDto copy) {
        return serviceCopy.save(copy);
    }

    @PostMapping("/save")
    public Copy save(@RequestBody CopyDto copy) {
        return serviceCopy.save(copy);
    }

}
