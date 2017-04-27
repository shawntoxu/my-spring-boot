package test.springboot.Dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

import test.springboot.App;

// 这里必须标注 @Component 或者 @Service 否则启动时不能注入  
//@Service
@Component
public class JdbcTemplateDao {
	
	private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	   public List<Map<String, Object>> getDataList(String sql){
		   logger.debug(" sql = " + sql );
	        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
	        for (Map<String, Object> map : list) {
	            Set<Entry<String, Object>> entries = map.entrySet( );
	                if(entries != null) {
	                    Iterator<Entry<String, Object>> iterator = entries.iterator( );
	                    while(iterator.hasNext( )) {
	                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
	                    Object key = entry.getKey( );
	                    Object value = entry.getValue();
//	                    System.out.println(key+":"+value);
	                    logger.info(key+":"+value);
	                }
	            }
	        }
	        return list;
	    }
	
	   public Object insertData(final List<LogAccessNum> datalist){
		   /**
		    * table 
		    * 	id	     int(11)
				host	 varchar(255)
				path	 varchar(255)
				code	 int(3)
				time_day int(11)
				num	     int(11)
				time	 int(11)
				time_min varchar(10)
		    */
		   String isql = "insert into log.log_access_num( `host`, `path`, `code`, `time_day`, `num`, `time`, `time_min`) values(?,?,?,?,?,?,?)" ;
		   jdbcTemplate.batchUpdate(isql, new BatchPreparedStatementSetter() {
			 
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// TODO Auto-generated method stub
				LogAccessNum oo = datalist.get(i);
				
				ps.setString(1, oo.getHost());
				ps.setString(2, oo.getPath());
				ps.setInt(3, oo.getCode());
				ps.setInt(4, oo.getTime_day());
				ps.setInt(5, oo.getNum());
				ps.setInt(6, oo.getTime());
				ps.setString(7, oo.getTime_min());
				
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return datalist.size();
			}
		});
		   
		   
		   return null ;
	   }
	   
	
	
}
