package allen.wqplis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import allen.wqplis.model.BeachLatest;
import allen.wqplis.repository.BeachLatestRepository;

@Repository
@Service("BeachLatestService")
@EnableTransactionManagement
public class BeachLatestService {

//	@PersistenceContext(unitName = "wqplis")
//	@Qualifier(value = "wqplisEntityManagerFactory")
//	private EntityManager em;

	@Autowired
	private BeachLatestRepository repo;

	@Transactional("wqplisTransactionManager")
	public List<BeachLatest> all() {
		return repo.findAll();
	}
}
