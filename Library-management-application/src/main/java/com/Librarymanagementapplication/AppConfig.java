package com.Librarymanagementapplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class AppConfig {


	     //Creating Connection with Redis
	     @Bean
	     public RedisConnectionFactory redisConnectionFactory() {
	         return new LettuceConnectionFactory();
	     }

	     @Bean
	     public RedisTemplate<String, Object> redisTemplate() {
	         RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
	         redisTemplate.setConnectionFactory(redisConnectionFactory());
	         redisTemplate.setHashKeySerializer(RedisSerializer.json());
	         redisTemplate.setKeySerializer(new StringRedisSerializer());
	         redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
	         redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
	         return redisTemplate;
	     }


}