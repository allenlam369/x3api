package allen.met.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import allen.met.model.TideLatest;

@Repository
public interface TideLatestRepository extends JpaRepository<TideLatest, Long> {

}
