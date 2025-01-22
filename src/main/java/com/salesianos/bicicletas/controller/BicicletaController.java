package com.salesianos.bicicletas.controller;

import com.salesianos.bicicletas.dto.EditBici;
import com.salesianos.bicicletas.dto.GetBiciDto;
import com.salesianos.bicicletas.model.Bicicleta;
import com.salesianos.bicicletas.service.BicicletaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicleta/")
@RequiredArgsConstructor
public class BicicletaController {

    private final BicicletaService bicicletaService;

    @GetMapping
    public List<GetBiciDto> getAll() {
        return bicicletaService.findAll()
                .stream()
                .map(GetBiciDto::of)
                .toList();
    }

    @GetMapping("/{id}")
    public Bicicleta getById(@PathVariable Long id) {
        return bicicletaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Bicicleta> create(@RequestBody EditBici nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        bicicletaService.save(nuevo));
    }

    @PutMapping("/{id}")
    public Bicicleta edit(@RequestBody EditBici aEditar,
                         @PathVariable Long id) {
        return bicicletaService.edit(aEditar, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bicicletaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
