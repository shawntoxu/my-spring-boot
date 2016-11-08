package test.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.springboot.beans.User;
// 允许跨域访问@CrossOrigin

//制定当前资源可以访问的来源
//如果不确定，所有来源都是允许的。
@CrossOrigin("http://mytest.ccc:9900")
@RestController
public class CorsTestController {
	
	
	@RequestMapping("/testcors")
	public String test(){
		return  "test data" ; 
	}
	
	@RequestMapping("/getjson")
	public User index(){
		User tuser =  new User() ;
			 tuser.setName("test");
			 tuser.setSex("man");
			 tuser.setAge(10);
			 tuser.setAddress("街道");
			 
			 List<String> tlist = new ArrayList<String>();
			 tlist.add("foot");
			 tlist.add("foot2");
			 
			 tuser.setFav(tlist);

		return  tuser ;
	}
}
