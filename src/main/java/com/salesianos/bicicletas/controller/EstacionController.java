package com.salesianos.bicicletas.controller;

import com.salesianos.bicicletas.dto.GetEstacionDto;
import com.salesianos.bicicletas.model.Estacion;
import com.salesianos.bicicletas.service.EstacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estacion/")
@RequiredArgsConstructor
@Tag(name = "Estaciçon", description = "El controlador de estaciones, para poder realizar todas las operaciones de gestión")
public class EstacionController {

    private final EstacionService estacionService;


    @Operation(summary = "Obtiene todas las estaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado estaciones",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetEstacionDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                 {
                                                     "id": 1,
                                                     "nombre": "Estación Central"
                                                 },
                                                 {
                                                     "id": 2,
                                                     "nombre": "Estación Norte"
                                                 }
                                             ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ninguna estación",
                    content = @Content),
    })
    @GetMapping
    public List<GetEstacionDto> getAll() {
        return estacionService.findAll()
                .stream()
                .map(GetEstacionDto::of)
                .toList();
    }


    @Operation(summary = "Obtiene una estación por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la estacion",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetEstacionDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": 1,
                                                "nombre": "Estación Central"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la estación",
                    content = @Content),
    })
    @GetMapping("/{id}")
    public GetEstacionDto getById(@PathVariable Long id) {
        return GetEstacionDto.of(estacionService.findById(id));
    }

    @Operation(summary = "Crea una estación por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado la estacion",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetEstacionDto.class)),
                            examples = {@ExampleObject(
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha creado la estación",
                    content = @Content),
    })
    @PostMapping
    public GetEstacionDto create(@RequestBody Estacion nuevo) {
        return GetEstacionDto.of(estacionService.save(nuevo));
    }

    @Operation(summary = "Edita una estacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha editado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Estacion.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ninguna estación",
                    content = @Content),
    })
    @PutMapping("/{id}")
    public GetEstacionDto edit(@RequestBody Estacion aEditar,
                             @PathVariable Long id) {
        return GetEstacionDto.of(estacionService.edit(aEditar, id));
    }

    @Operation(summary = "Borra una estacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Estacion.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha podido borrar la estación",
                    content = @Content),
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estacionService.delete(id);
    }
}
