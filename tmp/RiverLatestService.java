package allen.wqplis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import allen.wqplis.model.RiverLatest;
import allen.wqplis.repository.RiverLatestRepository;

@Repository
@Service("RiverLatestService")
@EnableTransactionManagement
public class RiverLatestService {
//	@PersistenceContext(unitName = "wqplis")
//	@Qualifier(value = "wqplisEntityManagerFactory")
//	private EntityManager em;

	@Autowired
	private RiverLatestRepository repo;

	@Transactional("wqplisTransactionManager")
	public List<RiverLatest> all() {
		return repo.findAll();
	}
}
