package allen.wqplis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allen.wqplis.model.BeachLatest;
import allen.wqplis.repository.BeachLatestRepository;

@RestController
@RequestMapping("/wqplis")
public class BeachLatestController {

	@Autowired
	private BeachLatestRepository repo;

	@GetMapping("/beachLatest")
	public List<BeachLatest> all() {
		return repo.findAll();
	}
}
