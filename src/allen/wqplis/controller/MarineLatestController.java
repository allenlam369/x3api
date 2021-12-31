package allen.wqplis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allen.wqplis.model.MarineLatest;
import allen.wqplis.repository.MarineLatestRepository;

@RestController
@RequestMapping("/wqplis")
public class MarineLatestController {
	@Autowired
	private MarineLatestRepository repo;

	@GetMapping("/marineLatest")
	public List<MarineLatest> all() {
		return repo.findAll();
	}
}
