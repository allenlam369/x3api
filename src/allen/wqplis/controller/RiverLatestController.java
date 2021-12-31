package allen.wqplis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allen.wqplis.model.RiverLatest;
import allen.wqplis.repository.RiverLatestRepository;

@RestController
@RequestMapping("/wqplis")
public class RiverLatestController {
	@Autowired
	private RiverLatestRepository repo;

	@GetMapping("/riverLatest")
	public List<RiverLatest> all() {
		return repo.findAll();
	}
}
