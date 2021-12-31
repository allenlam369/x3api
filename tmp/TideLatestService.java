package allen.met.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import allen.met.model.TideLatest;
import allen.met.repository.TideLatestRepository;

@Repository
@Service("TideLatestService")
public class TideLatestService {
	@Autowired
	private TideLatestRepository repo;

	@Transactional("metTransactionManager")
	public List<TideLatest> all() {
		return repo.findAll();
	}
}
