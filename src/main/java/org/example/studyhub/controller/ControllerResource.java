package org.example.studyhub.controller;

import org.example.studyhub.model.Resource;
import org.example.studyhub.model.ResourceType;
import org.example.studyhub.repository.ResourceRepository;
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

    @Autowired
    private ResourceRepository resourceRepository;

    //1.Get all resources
    @GetMapping
    public ResponseEntity<List<Resource>> getAll() {
        List<Resource> resources = resourceRepository.findAll();
    return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    //2. get resources on id
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Resource>> getResourceById(@PathVariable Long resourceId){
        return ResponseEntity.ok(resourceRepository.findById(resourceId));
    }
    //3. Get resource on Type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Resource>> getResourcesByType(@PathVariable("type") ResourceType type) {
        List<Resource> resources = resourceRepository.findByType(type);
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
    //4. Post opprett en ny resourse
    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource){
        resourceRepository.save(resource);
        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }
    //5. Update PUT resourse
    @PutMapping
    public ResponseEntity<Resource> updateResource(@RequestBody Resource resource){
        resourceRepository.save(resource);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    //6. Delete resourse on Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Resource> deleteResource(@PathVariable Long resourceId){
        resourceRepository.deleteById(resourceId);
        return ResponseEntity.noContent().build(); // Hvis det ikke kastes en exception, betyr det at brukeren ble slettet

    }
}
