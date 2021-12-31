package allen.met.controller;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import allen.met.model.Uvi;
import allen.met.repository.UviRepository;
import allen.met.service.UviService;

@RestController
@RequestMapping("/uvi")
public class UviController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private final UviRepository repo;

	@Autowired
	private UviService uService;

	// injection
	public UviController(UviRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/uvis")
	public List<Uvi> all() {
		return repo.findAll();
	}

	@GetMapping("/uvis/{id}")
	ResponseEntity<Uvi> one(@PathVariable long id) {
		Uvi uvi = repo.findById(id) //
				.orElseThrow(() -> new ObjectNotFoundException(id, "Uvi"));
		return ResponseEntity.ok().body(uvi);
	}

	// d1 and d2 in format yyyyMMdd_HHmm, in HKT if app server is in +8 timezone
	@GetMapping("/between")
	public List<Uvi> findBetween(@RequestParam String st, @RequestParam String ed) {
		return uService.findBetween(st, ed);
	}

	// d1 in format yyyyMMdd_HHmm, in HKT if app server is in +8 timezone
	@GetMapping("/on")
	public List<Uvi> findOnDate(@RequestParam String date) {
		return uService.findOnDate(date);
	}

	@GetMapping("/twoDays")
	public List<Uvi> twoDays() {
		return uService.twoDays();
	}

	@GetMapping("/oneWeek")
	public List<Uvi> oneWeek() {
		return uService.oneWeek();
	}

	@PostMapping(value = "/saveOrUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	Uvi newUvi(@RequestBody Uvi newUvi) {
		Uvi u = uService.saveOrUpdate(newUvi);
		logger.info("saveOrUpdate " + u);
		return u;
	}

}
