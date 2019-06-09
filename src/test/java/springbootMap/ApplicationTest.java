package springbootMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.map.Application;

/**
 * 1.测试类
 * 项目名称：springbootMap 
 * 类名称：ApplicationTest
 * 开发者：Lenovo
 * 开发时间：2019年6月9日上午11:47:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {


	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void browseCatalogTest() {
		String url = "http://localhost:8080/user/listUser";
		for(int i = 0; i < 100; i++) {
			final int num = i;
			new Thread(() -> {
				String result = testRestTemplate.postForObject(url,null, String.class);
				System.out.println("第"+num+"次"+result);
			}
					).start();
			/*final int num = i;
	        new Thread(() -> {
	        	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                params.add("id", "51");
	        	String result = testRestTemplate.postForObject(url,params, String.class);
                System.out.println("-------------" + result);
            }
            ).start();*/
		}
	}
}
