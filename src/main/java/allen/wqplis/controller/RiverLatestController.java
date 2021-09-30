package allen.wqplis.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allen.wqplis.model.RiverLatest;
import allen.wqplis.repository.RiverLatestRepository;

@RestController
@RequestMapping("/wqplis")
public class RiverLatestController {
	@Autowired
	RiverLatestRepository repo;

//	@Autowired
//	RiverLatestService mService;

	@PersistenceContext(unitName = "wqplis")
	@Qualifier(value = "wqplisEntityManagerFactory")
	private EntityManager em;

	@GetMapping("/riverLatest")
	public List<RiverLatest> all() {
		return repo.findAll();
	}
}
