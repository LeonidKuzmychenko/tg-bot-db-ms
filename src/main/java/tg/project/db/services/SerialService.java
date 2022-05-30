package tg.project.db.services;

import org.springframework.stereotype.Service;
import tg.project.db.models.Serial;
import tg.project.db.repositories.SerialRepository;


import java.util.Set;

@Service
public class SerialService {

    private final SerialRepository repository;

    public SerialService(SerialRepository repository) {
        this.repository = repository;
    }

    public Serial getSerialByApiIdAndCheckForExist(String apiId) {
        return repository.findByApiId(apiId).orElseGet(() -> repository.save(new Serial(apiId)));
    }

    public Set<Long> getUniqueSubscribedSerials() {
        return repository.getUniqueSubscribedSerials();
    }
}