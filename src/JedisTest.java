import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {
	
	@Test
	public void test() {
		
//		// 1��������Ӷ���
//		Jedis jedis = new Jedis("192.168.11.176", 6379);
//		
//		// 2����������
//		jedis.set("name", "jay");
//		
//		// 3����ȡ����
//		System.out.println(jedis.get("name"))
		
		// 1��������Ӷ���
		Jedis jedis = JedisPoolUtils.getJedis();;
		
		// 2����������
		jedis.set("name", "shake");
		
		// 3����ȡ����
		System.out.println(jedis.get("name"));
	}
	
}
