import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {
	
	@Test
	public void test() {
		
//		// 1、获得连接对象
//		Jedis jedis = new Jedis("192.168.11.176", 6379);
//		
//		// 2、设置数据
//		jedis.set("name", "jay");
//		
//		// 3、获取数据
//		System.out.println(jedis.get("name"))
		
		// 1、获得连接对象
		Jedis jedis = JedisPoolUtils.getJedis();;
		
		// 2、设置数据
		jedis.set("name", "shake");
		
		// 3、获取数据
		System.out.println(jedis.get("name"));
	}
	
}
