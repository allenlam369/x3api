package allen.met.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import allen.met.model.Tide;

@Repository
public interface TideRepository extends JpaRepository<Tide, Long> {
	
//	static String sql = "select \r\n"
//			+ "TO_CHAR(t.datetime, 'YYYYMMDD') as d,\r\n"
//			+ "TO_CHAR(datetime, 'YYYYMMDD-HH24') as prefix,\r\n"
//			+ "count(*)\r\n"
//			+ "from tide t\r\n"
//			+ "WHERE t.datetime between :st and :ed\r\n"
//			+ "GROUP BY d, prefix\r\n"
//			+ "having count(*) < :th";
//	
//	static String sql2 = "select to_char(t.datetime, 'yyyymmdd') as d, to_char(t.datetime, 'yyyymmdd-hh') as prefix, count(t)\r\n"
//			+ "from Tide t\r\n"
//			+ "WHERE t.datetime between :st and :ed\r\n"
//			+ "group by d, prefix\r\n"
//			+ "Having count(t) < :th\r\n";
//
//
//	@SuppressWarnings("rawtypes")
//	@Query(value = sql, nativeQuery = true)
//	
//	List getMissing(String sqlStr);
	
//	@Query(value = sql2, nativeQuery = true)
//	List getMissing(String st, String ed, Integer th);
	
}
