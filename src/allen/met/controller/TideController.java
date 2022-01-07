package allen.met.controller;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import allen.met.model.Tide;
//import allen.met.repository.TideRepository;
import allen.met.service.TideService;

@RestController
@RequestMapping("/tide")
public class TideController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TideService tService;

	@PersistenceContext(unitName = "met")
	@Qualifier(value = "metEntityManagerFactory")
	private EntityManager em;

	@PostMapping(value = "/saveOrUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	Tide newTide(@RequestBody Tide newTide) {
		Tide t = tService.saveOrUpdate(newTide);
		logger.info("saveOrUpdate " + t);
		return t;
	}

	// d1 and d2 in format yyyyMMdd_HHmm, in HKT if app server is in +8 timezone
	@GetMapping("/between")
	public List<Tide> findBetween(@RequestParam String st, @RequestParam String ed, @RequestParam int stationId) {
		return tService.findBetweenDates(st, ed, stationId);
	}

	@GetMapping("/twoDays")
	public List<Tide> twoDays(@RequestParam int stationId) {
		return tService.twoDays(stationId);
	}

	@GetMapping("/oneWeek")
	public List<Tide> oneWeek(@RequestParam int stationId) {
		return tService.oneWeek(stationId);
	}

	// st, ed will be a string like "2021-10-12T00:00:00+08"
	// th is a number, e.g. 100
	@GetMapping("/getMissingXX")
	public List<Object[]> getMissingXX(@RequestParam String st, String ed, Integer th) {
		List<Object[]> list = tService.getMissing(st, ed, th);

		for (Object[] arr : list) {
			try {
				String start = (String) arr[0];
				String end = (String) arr[1];
				Long threshold = (Long) arr[2];
				logger.info(start + " " + end + " " + threshold);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		logger.info("getMissingXX, list size " + list.size());

		return list;
	}

	// st, ed will be a string like "2021-10-12T00:00:00+08"
	// th is a number, e.g. 100
	@GetMapping("/getMissing")
	public List<Object[]> getMissing(@RequestParam String st, String ed, Integer th) {
		List<Object[]> list = tService.getMissing(st, ed, th);

		for (Object[] arr : list) {
			try {
				String start = (String) arr[0];
				String end = (String) arr[1];
				BigInteger threshold = (BigInteger) arr[2];
				logger.info(start + " " + end + " " + threshold);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		logger.info("getMissing, list size " + list.size());

		return list;
	}
}
