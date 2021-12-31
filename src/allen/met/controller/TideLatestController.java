package allen.met.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allen.met.model.TideLatest;
import allen.met.repository.TideLatestRepository;

@RestController
@RequestMapping("/met")
public class TideLatestController {

	@Autowired
	private TideLatestRepository repo;

	@GetMapping("/tideLatest")
	public List<TideLatest> all() {
		return repo.findAll();
	}

}
