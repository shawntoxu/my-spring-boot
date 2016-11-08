package test.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.xmlrpc.base.Array;

import test.springboot.Dao.RedisDao;
/**
 * 
 * @author shawn.wang
 *	
 */
@RestController
@RequestMapping("/get-redis")
public class TestRedisController {
	
	@Autowired
	private RedisDao redisDao ; 

	@RequestMapping(value="/{key}",method=RequestMethod.GET)
	public String  getKey(@PathVariable("key") String key){
		
		return redisDao.getValue(key);
	}
	
	@RequestMapping(value="/list/{key}",method=RequestMethod.GET)
	public String  getLeftValue(@PathVariable("key") String key){
		
		return redisDao.getListValue(key);
	}
	
	//查询 list 范围  　( lrang xxx  0 10) 
	// RPUSH mytest  a b c d e 
	//curl  http://localhost:9999/get-redis/listrang/mytest/0/10   will return  ["a","b","c","d","e"]  
	@RequestMapping(value="/listrang/{key}/{start}/{end}",method=RequestMethod.GET)
	public List<String>  getLeftValue(@PathVariable("key") String key,@PathVariable("start") long start,@PathVariable("end") long end){
		return redisDao.getListValue(key,start,end);
	}
	
//	 hmset user name "wx"  age 10 address "xi'an"  
	
	@RequestMapping(value="/hash/{key}",method=RequestMethod.GET)
	public List<Object>  gethash(@PathVariable("key") String key){
		List  a = new ArrayList<String>();
		a.add("name");
		a.add("age");
		a.add("address");
		return redisDao.getHash(key,a);
	}

}
