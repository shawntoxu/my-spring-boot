package test.springboot;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// 官方说明  作为zk 服务端 或者 客户端 需要添加的      但是 测试这个参数加不加 都无所谓
//@EnableDiscoveryClient  
public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
    	
    		ApplicationContext  ctx =  SpringApplication.run(App.class,args);
    		logger.info("==========start a server begin=================");

    		//get all beans provided by spring boot
    		String[]  beanNames = ctx.getBeanDefinitionNames() ;
    		
    		Arrays.sort(beanNames);
    		
    		for (String beanName:beanNames) {
				System.out.println(beanName);
			}
    		
    		logger.info("==========start a server end=================");
    }
}
