package allen.met.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import allen.met.model.Uvi;

@Repository
public interface UviRepository extends JpaRepository<Uvi, Long> {

}
