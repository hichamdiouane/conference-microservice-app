package diouane.hicham.conference_service.repository;

import diouane.hicham.conference_service.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
