package allen.met.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import allen.met.model.Tide;

@Repository
public interface TideRepository extends JpaRepository<Tide, Long> {

}
