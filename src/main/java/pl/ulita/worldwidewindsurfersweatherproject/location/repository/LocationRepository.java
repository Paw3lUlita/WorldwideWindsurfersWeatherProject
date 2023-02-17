package pl.ulita.worldwidewindsurfersweatherproject.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ulita.worldwidewindsurfersweatherproject.location.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
