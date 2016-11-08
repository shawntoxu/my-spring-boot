package test.springboot.Dao;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.SyslogOutputStream;

@Component
public class RedisDao {
	
	private static final  Logger  loger = LoggerFactory.getLogger(RedisDao.class);
	
	//StringRedisTemplate就相当于RedisTemplate<String, String>的实现。
	@Autowired
	private StringRedisTemplate stringRedisTemplate  ;
	
//	private RedisConnectionFactory s;
	
	public String getValue(String key){
		
		ValueOperations<String, String>  op = stringRedisTemplate.opsForValue();
//		op.set("key", "value");
		String value = op.get(key);
		return value ; 
	}
	
	public String getListValue(String key){

		ListOperations<String, String> op = stringRedisTemplate.opsForList();
		
		//getLeft value
		String s = op.leftPop(key);
		
		return s ;
		
	}
	
	public List<String> getListValue(String key,long start,long end){
		
		 ListOperations<String, String> op = stringRedisTemplate.opsForList();
		 List<String> list = op.range(key, start, end);
		 
		return list ;
		
	}
	
	
	public List<Object> getHash(String key ,List hashkey){
		
		HashOperations<String, Object, Object> op =  stringRedisTemplate.opsForHash();
		List<Object> list = op.multiGet(key, hashkey);
		for (Object object : list) {
			loger.info(object.toString());
		}
		 
		return list ;
		
	}

}
