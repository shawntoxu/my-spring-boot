package test.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController  meaning it’s ready for use by Spring MVC to handle to requests 
@RestController  
public class TestController {

	@RequestMapping("/status")
	public String index(){
		return "server running !" ;
	}
	
	
}
