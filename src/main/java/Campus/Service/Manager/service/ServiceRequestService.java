package Campus.Service.Manager.service;

import Campus.Service.Manager.model.ServiceRequest;
import Campus.Service.Manager.repository.ServiceRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository repository;

    public ServiceRequestService(ServiceRequestRepository repository) {
        this.repository = repository;
    }

    public ServiceRequest createRequest(ServiceRequest request) {
        request.setStatus("OPEN");
        request.setCreatedAt(LocalDateTime.now());

        return repository.save(request);
    }

    public List<ServiceRequest> getAllRequests() {
        return repository.findAll();
    }

    public Optional<ServiceRequest> getRequestById(Long id) {
        return repository.findById(id);
    }

    public ServiceRequest updateRequest(Long id, ServiceRequest updatedRequest) {

        ServiceRequest existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        existing.setTitle(updatedRequest.getTitle());
        existing.setDescription(updatedRequest.getDescription());
        existing.setCategory(updatedRequest.getCategory());
        existing.setPriority(updatedRequest.getPriority());
        existing.setStatus(updatedRequest.getStatus());

        return repository.save(existing);
    }

    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }
}