package org.example.studyhub.controller;

import org.example.studyhub.model.CourseModule;
import org.example.studyhub.model.Resource;
import org.example.studyhub.repository.ModuleRepository;
import org.example.studyhub.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/courseModules") // Alle API-kall starter med /api/modules
public class ControllerModule {

    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    //1. Get all modules
    @GetMapping
    public List<CourseModule> getAllModules() {
        return moduleRepository.findAll();
    }
    //2. Get module by Id
    @GetMapping ("/{id}")
    public ResponseEntity<CourseModule> getModuleById(@PathVariable Long moduleId) {
        Optional<CourseModule> courseModule = moduleRepository.findById(moduleId);
        if (courseModule.isPresent()) {
            return ResponseEntity.ok(courseModule.get());
        }
    return ResponseEntity.notFound().build();
    }
    //3. Get all resoures in one module
    @GetMapping("/{id}/resources")
    public ResponseEntity<List<Resource>> getModuleResources(@PathVariable Long moduleId) {
        Optional<CourseModule> courseModule = moduleRepository.findById(moduleId);
        if (courseModule.isPresent()) {
            List<Resource> resources = resourceRepository.findByCourseModule(courseModule.get());
            return new ResponseEntity<>(resources, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //4.Post new module
    @PostMapping
    public ResponseEntity<CourseModule> createModule(@RequestBody CourseModule courseModule) {
        CourseModule savedModule = moduleRepository.save(courseModule);
        return ResponseEntity.ok(savedModule);
    }
    //5. Update module Put
    @PutMapping
    public ResponseEntity<CourseModule> updateModule(@RequestBody CourseModule courseModule) {
        CourseModule savedModule = moduleRepository.save(courseModule);
        return ResponseEntity.ok(savedModule);
    }
    //6. Delete module based on Id
    @DeleteMapping("/{id}")
    public ResponseEntity<CourseModule> deleteModule(@PathVariable Long moduleId) {
        moduleRepository.deleteById(moduleId);
        return ResponseEntity.noContent().build(); // bruker slettes hvis det ikke er feil
    }


}
