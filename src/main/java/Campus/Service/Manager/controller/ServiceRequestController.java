package Campus.Service.Manager.controller;

import Campus.Service.Manager.model.ServiceRequest;
import Campus.Service.Manager.service.ServiceRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "*")
public class ServiceRequestController {

    private final ServiceRequestService service;

    public ServiceRequestController(ServiceRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceRequest createRequest(@RequestBody ServiceRequest request) {
        return service.createRequest(request);
    }

    @GetMapping
    public List<ServiceRequest> getAllRequests() {
        return service.getAllRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequest> getRequestById(@PathVariable Long id) {

        return service.getRequestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequest> updateRequest(
            @PathVariable Long id,
            @RequestBody ServiceRequest request) {

        try {
            return ResponseEntity.ok(service.updateRequest(id, request));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {

        service.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}