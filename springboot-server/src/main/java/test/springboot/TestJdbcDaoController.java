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
		//curl -H "Content-Type: application/json" -X POST  --data '[{"host":"172.30.80.111","path":"/adv/test?appid=10","code":444,"time_day":20170422,"num":111,"time":123456789,"time_min":"182959"}]'  http://172.30.80.89:9999/data/insert
		@RequestMapping(value="/data/insert",method=RequestMethod.POST)
		public Object insertData(@RequestBody List<LogAccessNum> logobj ){
//			logger.info(Arrays.toString(logobj.toArray()));
				
			
		for (LogAccessNum logAccessNum : logobj) {
			logger.info(logAccessNum.getHost());
		}
//		logger.info(StringUtils.join(logobj.toArray()));
			List datalist = new ArrayList() ; 
			dataService.insertData(logobj) ;
			return "ok" ; 
		}
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
