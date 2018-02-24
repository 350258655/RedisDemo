import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {
	
	@Test
	public void test() {
		
		

		Jedis jedis = JedisPoolUtils.getJedis();;
		

		jedis.set("name", "xixi");
		

		System.out.println(jedis.get("name"));
	}
	
}
