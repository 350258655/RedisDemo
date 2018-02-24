import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {
	private static JedisPool pool = null;

	static {
		// �����ļ�
		InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ��ó��������ļ�
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));// ������ø���
		config.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));// ��С���ø���
		config.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));// ���������

		// �������Ӷ���
		pool = new JedisPool(config, pro.getProperty("redis.url"), Integer.parseInt(pro.get("redis.port").toString()));
	}

	/**
	 * �����ӳ��л�ȡJedis����
	 * 
	 * @return
	 */
	public static Jedis getJedis() {
		return pool.getResource();
	}

}
