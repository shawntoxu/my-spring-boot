package test.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import test.springboot.Dao.JdbcTemplateDao;

@Service
public class DataService {
	private static final Logger logger = LoggerFactory.getLogger(DataService.class);
	
	@Autowired
	private JdbcTemplateDao jdbcTemplateDao ;

	public Object getData(){
		String sql = "select * from monitor_actions";
		logger.info("sql ====" + sql);
		return  jdbcTemplateDao.getDataList(sql);
		
	}
		
	public Object insertData(List datalist){
		String sql = "" ;
		jdbcTemplateDao.insertData(datalist);
		logger.info("");
		return null ; 
	}
}
