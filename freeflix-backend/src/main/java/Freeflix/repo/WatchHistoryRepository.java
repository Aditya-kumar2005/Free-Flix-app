package Freeflix.repo;

import Freeflix.model.WatchHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface WatchHistoryRepository extends MongoRepository<WatchHistory, String> {
  List<WatchHistory> findByUserId(String userId);
}