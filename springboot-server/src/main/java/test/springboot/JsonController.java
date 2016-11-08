package test.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.springboot.beans.User;

/**
 * @author shawn.wang
 *  @RestController默认应该渲染为JSON响应  
 */
@RestController
public class JsonController {
	
	@RequestMapping("/getinfo")
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
