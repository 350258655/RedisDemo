import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {
	
	@Test
	public void test() {
		
		
		// 1��������Ӷ���
		Jedis jedis = JedisPoolUtils.getJedis();;
		
		// 2����������
		jedis.set("name", "shake");
		
		// 3����ȡ����
		System.out.println(jedis.get("name"));
	}
	
}
