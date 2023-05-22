package sg.edu.nus.iss.visa.ssf_day14workshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

@Value("${spring.redis.host}")
private String redisHost;

@Value("${spring.redis.port}")
private int redisPort;

@Value("${spring.redis.username}")
private String redisUser;

@Value("${spring.redis.password}")
private String redisPassword;

@Bean
@Scope("singleton")
public RedisTemplate<String, Object> getRedisTemplate(){

    final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
    config.setHostName(redisHost);
    config.setPort(redisPort);

    if (!redisUser.isEmpty()&&!redisPassword.isEmpty()){
        config.setUsername(redisUser);
        config.setPassword(redisPassword);
    }

    config.setDatabase(0);

    //creating and configuring connection pool -- day 14 slide 17
    final JedisClientConfiguration jdisClient = JedisClientConfiguration.builder().build();

    //setting up connection with redis database
    final JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jdisClient);

    //initialize and validation connection factory
    jedisFac.afterPropertiesSet();
    final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

    //keys (stringredisserializer are in UTF-8). use hashvalue. Why??
    //associate to redis connection
    redisTemplate.setConnectionFactory(jedisFac);

    //set the list key and hash key serialization type to string
    redisTemplate.setHashKeySerializer(new StringRedisSerializer()); //key for hash
    // redisTemplate.setHashValueSerializer(new StringRedisSerializer()); //key for value

    //use this object serializer as we want object, dun want string.
    //enable redis to store java object on the value column (redis hashset)
    // enabling the java objecet as values in Redis
    RedisSerializer<Object> objSerializer = new JdkSerializationRedisSerializer(getClass().getClassLoader());
    redisTemplate.setValueSerializer(objSerializer); //value for list
    redisTemplate.setHashValueSerializer(objSerializer); //value for hash

    return redisTemplate;
}


}
