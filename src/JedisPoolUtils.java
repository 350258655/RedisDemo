import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {
	private static JedisPool pool = null;

	static {
		// 加载文件
		InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 获得池子配置文件
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));// 最大闲置个数
		config.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));// 最小闲置个数
		config.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));// 最大连接数

		// 创建池子对象
		pool = new JedisPool(config, pro.getProperty("redis.url"), Integer.parseInt(pro.get("redis.port").toString()));
	}

	/**
	 * 从连接池中获取Jedis对象
	 * 
	 * @return
	 */
	public static Jedis getJedis() {
		return pool.getResource();
	}

}
