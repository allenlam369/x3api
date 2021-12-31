package allen.met.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import allen.met.model.Tide;
import allen.met.repository.TideRepository;

@Repository
@Service("TideService")
public class TideService {
	static String pattern = "yyyyMMdd_HHmm"; // for reading input data
	static SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	static String pattern2 = "yyyyMMdd"; // for reading input data
	static SimpleDateFormat sdf2 = new SimpleDateFormat(pattern2);
	static String pattern3 = "yyyy-MM-dd HH:mm:ss"; // for Spring to parse datetime
	static SimpleDateFormat sdf3 = new SimpleDateFormat(pattern3);

	@PersistenceContext(unitName = "met")
	@Qualifier(value = "metEntityManagerFactory")
	private EntityManager em;

	@Autowired
	private TideRepository repo;

	@SuppressWarnings("unchecked")
	public List<Tide> findBetween(String d1, String d2, long id) {
		System.err.println("service " + d1 + " " + d2 + " " + id);
		Query q = em.createNamedQuery("Tide.findBetweenDates");
		try {
			Date date1 = sdf.parse(d1);
			Date date2 = sdf.parse(d2);

			q.setParameter(1, date1);
			q.setParameter(2, date2);
			q.setParameter(3, id);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		return q.getResultList();
	}

	@Transactional("metTransactionManager")
	public Tide saveOrUpdate(Tide t) {
		Query q = em.createNamedQuery("Tide.findByDatetimeStationId");
		q.setParameter(1, t.getDatetime());
		q.setParameter(2, t.getStation_id());

		try {
			// Update the existing datetime + stationId row
			Tide tt = (Tide) q.getSingleResult();

			// null result will be caught by NoResultException
			// duplicate return will be caught by NonUniqueResultException
			// no catch, so that there is one existing row

			Tide existingTide = repo.getById(tt.getId());
			existingTide.setHeight(t.getHeight());
			return repo.save(existingTide);
		}
		// no existing datetime + stationId, new data
		// save it
		catch (NoResultException e) {
			return repo.save(t);
		}
		// it should not happen, or else the db is broken
		catch (NonUniqueResultException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Transactional("metTransactionManager")
	@SuppressWarnings("unchecked")
	public List<Tide> findBetweenDates(String d1, String d2, int stationId) {
		Query q = em.createNamedQuery("Tide.findBetweenDates");
		try {
			Date date1 = sdf.parse(d1);
			Date date2 = sdf.parse(d2);
			q.setParameter(1, date1);
			q.setParameter(2, date2);
			q.setParameter(3, stationId);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		return q.getResultList();
	}

	public List<Tide> twoDays(int stationId) {
		return queryBetweenDays(-1, 1, stationId);
	}

	public List<Tide> oneWeek(int stationId) {
		return queryBetweenDays(-6, 1, stationId);
	}

	@SuppressWarnings("unchecked")
	private List<Tide> queryBetweenDays(int st, int ed, int stationId) {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		cal1.add(Calendar.DAY_OF_MONTH, st);

		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		cal2.add(Calendar.DAY_OF_MONTH, ed);

		Query q = em.createNamedQuery("Tide.findBetweenDates");
		q.setParameter(1, cal1.getTime());
		q.setParameter(2, cal2.getTime());
		q.setParameter(3, stationId);
		return q.getResultList();
	}

//	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
//		List<T> r = new ArrayList<T>(c.size());
//		for (Object o : c)
//			r.add(clazz.cast(o));
//		return r;
//	}

}
