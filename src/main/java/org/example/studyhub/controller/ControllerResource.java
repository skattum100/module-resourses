package org.example.studyhub.controller;

import org.example.studyhub.model.Resource;
import org.example.studyhub.model.ResourceType;
import org.example.studyhub.repository.ResourceRepository;
import org.example.studyhub.service.ResourceService;
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

    public ControllerResource(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    //1.Get all resources
    @GetMapping
    public ResponseEntity<List<Resource>> getAll() {
        List<Resource> resources = resourceService.findAll();
    return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    //2. get resources on id
    @GetMapping ("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id){
        return resourceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //3. Get resource on Type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Resource>> getResourcesByType(@PathVariable("type") ResourceType type) {
        List<Resource> resources = resourceService.findByType(type);
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
    //4. Post opprett en ny resourse
    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource){
        resourceService.save(resource);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }
    //5. Update PUT resourse
    @PutMapping
    public ResponseEntity<Resource> updateResource(@RequestBody Resource resource){
        resourceService.save(resource);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    //6. Delete resourse on Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Resource> deleteResource(@PathVariable Long id){
        resourceService.deleteById(id);
        return ResponseEntity.noContent().build(); // Hvis det ikke kastes en exception, betyr det at brukeren ble slettet

    }
}
