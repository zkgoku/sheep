package com.shaunk;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SheepApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {

//		stringRedisTemplate.opsForValue();
		String hashKey = "hash_demo_01";
		Map putMap = Maps.newConcurrentMap();
		putMap.put("userId", 1);
		putMap.put("username", "小大先生");
//		hashOperations.put(hashKey, putMap, putMap);
//
//		Object o = hashOperations.get(hashKey, putMap);
//
//		System.out.println(JSON.toJSONString(o));

//		redisTemplate.opsForHash().putAll(hashKey, putMap);
//
//		Map map = redisTemplate.opsForHash().entries(hashKey);
//		System.out.println(JSON.toJSONString(map));

//		stringRedisTemplate.opsForSet().add("set:01", "java", "spring", "mysql");
//		stringRedisTemplate.opsForSet().add("set:02", "java", "jquery", "mysql");
//		stringRedisTemplate.opsForSet().add("set:all", "java", "jquery", "spring" , "mysql");
//		boolean hasKey = stringRedisTemplate.opsForSet().isMember("set:01", "docker");
//		System.out.println(hasKey);
		Set<String> a = stringRedisTemplate.opsForSet().difference("set:01", "set:02");
		Set<String> b = stringRedisTemplate.opsForSet().difference("set:02", "set:01");
		Set<String> c = stringRedisTemplate.opsForSet().union("set:all", "set:01");
		Set<String> d = stringRedisTemplate.opsForSet().intersect("set:01", "set:02");
		System.out.println(JSON.toJSONString(a));
		System.out.println(JSON.toJSONString(b));
		System.out.println(JSON.toJSONString(c));
		System.out.println(JSON.toJSONString(d));
	}

}
