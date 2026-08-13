package Freeflix.repo;

import Freeflix.model.AdSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface AdSlotRepository extends MongoRepository<AdSlot, String> {
  List<AdSlot> findByActiveTrue();
}