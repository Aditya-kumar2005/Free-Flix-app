package Freeflix.repo;


import Freeflix.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
  List<Review> findByMovieId(String movieId);
}
