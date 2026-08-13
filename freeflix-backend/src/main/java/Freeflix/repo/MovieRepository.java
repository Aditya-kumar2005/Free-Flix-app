package Freeflix.repo;


import Freeflix.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {
  List<Movie> findTop10ByOrderByReleaseDateDesc();
  List<Movie> findByGenresIn(List<String> genres);
}
