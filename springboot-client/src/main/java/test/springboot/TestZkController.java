package test.springboot;

import java.util.List;

import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author shawn.wang
 *  zk 客户端 
 *  发现有哪些服务可用
 */
//@Configuration
//@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@RequestMapping("/getZk")
public class TestZkController {
	
	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private DiscoveryClient discovery;
	
	/**
	 * loadBalancer 动态发现一个 可用服务  返回 zk get 结果，类似如下
	 * {
		"serviceId": "myapp-name",
		"server": {
		"host": "172.30.80.127",
		"port": 9999,
		"id": "172.30.80.127:9999",
		"zone": "UNKNOWN",
		"readyToServe": true,
		"metaInfo": {
		"serverGroup": null,
		"instanceId": "f84ea36c-a652-4e49-80e5-89705cc55754",
		"serviceIdForDiscovery": null,
		"appName": "myapp-name"
		},
		"alive": true,
		"hostPort": "172.30.80.127:9999"
		},
		"secure": false,
		"metadata": {},
		"host": "172.30.80.127",
		"port": 9999,
		"uri": "http://172.30.80.127:9999"
		}
	 * @return
	 */
	@RequestMapping("/discovery")
	public Object discovery() {
		org.springframework.cloud.client.ServiceInstance  oneService  = loadBalancer.choose("myapp-name");
		System.out.println(oneService);// bootstrap.yml  中 spring.application.name ，注册到zk的应用名称
		return oneService;
	}
	/**
	 * 取得所有的 可用服务名称 
	 * 
	 * [
		"myapp-name-1",
		"myapp-name-2"
		]
	 * @return
	 */
	@RequestMapping("/all")
	public Object all() {
		List<String> allService = discovery.getServices();
		System.out.println();
		return allService;
	}

}
