package allen.wqplis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import allen.wqplis.model.BeachLatest;

@Repository
public interface BeachLatestRepository extends JpaRepository<BeachLatest, String> {

}
