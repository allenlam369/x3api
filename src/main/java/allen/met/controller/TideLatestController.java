package allen.met.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allen.met.model.TideLatest;
import allen.met.repository.TideLatestRepository;

@RestController
@RequestMapping("/met")
public class TideLatestController {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private final TideLatestRepository repo;

	@PersistenceContext(unitName = "met")
	@Qualifier(value = "metEntityManagerFactory")
	private EntityManager em;

	// injection
	public TideLatestController(TideLatestRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/tideLatest")
	public List<TideLatest> all() {
		return repo.findAll();
	}

}
