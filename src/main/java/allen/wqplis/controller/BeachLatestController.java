package allen.wqplis.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allen.wqplis.model.BeachLatest;
import allen.wqplis.repository.BeachLatestRepository;

@RestController
@RequestMapping("/wqplis")
public class BeachLatestController {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BeachLatestRepository repo;

//	@Autowired
//	BeachLatestService bService;

	@PersistenceContext(unitName = "wqplis")
	@Qualifier(value = "wqplisEntityManagerFactory")
	private EntityManager em;

	// injection
	public BeachLatestController(BeachLatestRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/beachLatest")
	public List<BeachLatest> all() {
		return repo.findAll();
	}

}
