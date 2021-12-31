package allen.wqplis.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import allen.wqplis.model.MarineLatest;
import allen.wqplis.repository.MarineLatestRepository;

@Repository
@Service("MarineLatestService")
@EnableTransactionManagement
public class MarineLatestService {
	@PersistenceContext(unitName = "wqplis")
	@Qualifier(value = "wqplisEntityManagerFactory")
	private EntityManager em;

	@Autowired
	private MarineLatestRepository repo;

	@Transactional("wqplisTransactionManager")
	public List<MarineLatest> all() {
		return repo.findAll();
	}
}
