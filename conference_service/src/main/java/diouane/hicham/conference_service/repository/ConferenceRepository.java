package diouane.hicham.conference_service.repository;

import diouane.hicham.conference_service.entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
