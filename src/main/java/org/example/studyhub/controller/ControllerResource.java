package org.example.studyhub.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.studyhub.dto.CreateResourceDTO;
import org.example.studyhub.dto.ResourceDTO;
import org.example.studyhub.dto.UpdateResourceDTO;
import org.example.studyhub.mapper.ResourceMapper;
import org.example.studyhub.model.Resource;
import org.example.studyhub.model.ResourceType;
import org.example.studyhub.repository.ResourceRepository;
import org.example.studyhub.service.ResourceService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/resources") // Alle API-kall starter med /api/resource
public class ControllerResource {


    private final ResourceService resourceService;
    private final ResourceMapper resourceMapper;

    public ControllerResource(ResourceService resourceService, ResourceMapper resourceMapper) {
        this.resourceService = resourceService;
        this.resourceMapper = resourceMapper;
    }



    @Operation(summary = "Get all resources", description = "Retrieves a list of all learning resources")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resources retrieved",
                    content = @Content(schema = @Schema(implementation = ResourceDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ResourceDTO>> getAll() {
        List<Resource> resources = resourceService.findAll();
        List<ResourceDTO> dtos= resourceMapper.toDTOList(resources);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @Operation(summary = "Get resource by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resource found",
                    content = @Content(schema = @Schema(implementation = ResourceDTO.class))),
            @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content)
    })
    @GetMapping ("/{id}")
    public ResponseEntity<ResourceDTO> getResourceById(@PathVariable Long id){
        Resource resource = resourceService.findById(id);
        ResourceDTO dto = resourceMapper.toDTO(resource);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
    @Operation(summary = "Get resources by type", description = "Retrieves resources filtered by their type")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resources retrieved by type",
                    content = @Content(schema = @Schema(implementation = ResourceDTO.class))),
            @ApiResponse(responseCode = "404", description = "No resources found for given type", content = @Content)
    })
    @GetMapping("/type/{type}")
    public ResponseEntity<List<ResourceDTO>> getResourcesByType(@PathVariable("type") ResourceType type) {
        List<Resource> resources = resourceService.findByType(type);
        List<ResourceDTO> dtos= resourceMapper.toDTOList(resources);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @Operation(summary = "Create a new resource", description = "Creates a new learning resource")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Resource created successfully",
                    content = @Content(schema = @Schema(implementation = ResourceDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ResourceDTO> createResource(@Valid @RequestBody CreateResourceDTO dto) {
        Resource entity = resourceMapper.fromCreateDTO(dto); //mapper DTO til Resource
        Resource saved = resourceService.save(entity); // Lagrer i DB
        ResourceDTO response = resourceMapper.toDTO(saved);// mapper tilbake til output DTO
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing resource", description = "Updates a resource using the provided ID and new data")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resource updated successfully",
                    content = @Content(schema = @Schema(implementation = ResourceDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content)
    })
    @PutMapping
    public ResponseEntity<ResourceDTO> updateResource(@PathVariable Long id, @Valid @RequestBody UpdateResourceDTO dto){
        dto.setId(id); //setter ID fra URL inn i DTO
        Resource entity = resourceMapper.fromUpdateDTO(dto); //mapper DTO til Resource
        Resource updated = resourceService.save(entity); //Lagrer oppdatert ressurs
        ResourceDTO response = resourceMapper.toDTO(updated); // sender DTO tilbake
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete a resource", description = "Deletes a specific resource by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Resource deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id){
        resourceService.deleteById(id);
        return ResponseEntity.noContent().build(); // Hvis det ikke kastes en exception, betyr det at brukeren ble slettet

    }
    @PostMapping("/resources")
    public ResponseEntity<?> createResource(@RequestBody ResourceDTO resourceDTO) {
        try {
            // Midlertidig dummy:
            return ResponseEntity.ok("Ressurs opprettet (dummy).");
        } catch (Exception e) {
            e.printStackTrace(); // Viktig for feilsøking
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}