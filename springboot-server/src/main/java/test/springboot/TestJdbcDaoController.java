package test.springboot;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.springboot.Dao.JdbcTemplateDao;
import test.springboot.service.DataService;

/**
 * 
 * @author 测试jdbctemplate 连接
 */
@RestController
public class TestJdbcDaoController {
	
		@Autowired
		private DataService dataService ;

		@RequestMapping("/getjdbc-data")
		public Object getData(){
			return  dataService.getData();
			
		}
//		
		
//		@Autowired
//		private JdbcTemplate jdbcTemplate ;
		
//		@RequestMapping("/getjdbc-data")
//		 public List<Map<String, Object>> getDataList(){
//			String sql = "select * from monitor_actions";
//	        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
//	        for (Map<String, Object> map : list) {
//	            Set<Entry<String, Object>> entries = map.entrySet( );
//	                if(entries != null) {
//	                    Iterator<Entry<String, Object>> iterator = entries.iterator( );
//	                    while(iterator.hasNext( )) {
//	                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
//	                    Object key = entry.getKey( );
//	                    Object value = entry.getValue();
//	                    System.out.println(key+":"+value);
//	                }
//	            }
//	        }
//	        return list;
//	    }
}
