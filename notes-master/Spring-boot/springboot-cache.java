--------------------
springboot-cache	|
--------------------
	# �ο�
		https://blog.csdn.net/u012373815/article/details/54564076

	# ����
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-cache</artifactId>
		</dependency>
	
	# ����
		@EnableCaching
			* Spring Boot���������˳��ȥ��⻺���ṩ�ߣ� 
				Generic 
				JCache (JSR-107) 
				EhCache 2.x 
				Hazelcast 
				Infinispan 
				Redis 
				Guava 
				Simple 
			* ���˰�˳�������,Ҳ����ͨ����������spring.cache.type ��ǿ��ָ��,Ĭ����simple����
				

	# spring ����֧��,���������һ�� CacheManager��Cache�ӿ�
		org.springframework.cache.CacheManager
		org.springframework.cache.Cache
	
	# spring֧�ֵĻ�����
		SimpleCacheManager
			* ֱ��ʹ����һ�� Collection ���洢
		ConcurrentMapCache
			* ʹ�� ConcurrentMap ���洢
		EhCacheCacheManager
			* ʹ��EhCache��Ϊ���漼��
		RedisCacheManager
			* ʹ��Redis��Ϊ���漼��
	
--------------------
����ʽע��			|
--------------------
	@Cacheable
		# ������ڻ���,ֱ�ӷ���,�����ڵ��÷�����ȡ������,���뻺��
		# �������һ������ʱ���ʾ�������еķ�������֧�ֻ����
		# ����
			@AliasFor("cacheNames")
			String[] value() default {};

			@AliasFor("value")
			String[] cacheNames() default {};

			String key() default "";
				* Ĭ��key���ɹ���
					- ���û�в���,��ʹ��0��Ϊkey 
					- ���ֻ��һ������,ʹ�øò�����Ϊkey 
						* ��ehcache��,��ʱ,key-typeӦ���ǲ�������
					- ����ֶ������,ʹ�ð������в�����hashCode��Ϊkey

				* ֧��ʹ��SpringEL���ʽ
					@Cacheable(value = "user", key = "#user.id"),ʹ��user��id��Ϊ����
					public User create(User user)

					@Cacheable(cacheNames="books", key="#map['bookid'].toString()")
					public Book findBook(Map<String, Object> map)

			String keyGenerator() default "";
			String cacheManager() default "";
			String cacheResolver() default "";
			String condition() default "";
			String unless() default "";
				* �����������null,Ҳ�ᱻ��Ϊ��һ�ַ���ֵ,nullҲ�ᱻ����,��Щʱ���ⲻ������ϣ����
				* ͨ��������������,��ֹ����null,������Ϊnull,��ô�Ͳ�����
					@Cacheable(value = "post",unless="#result == null")

			boolean sync() default false;

	@CachePut
		# ������ô��,����ѷ�������ֵ���뻺����
		# CachePut��ע�ķ�����ִ��ǰ����ȥ��黺�����Ƿ����֮ǰִ�й��Ľ��,����ÿ�ζ���ִ�и÷���,����ִ�н���Լ�ֵ�Ե���ʽ����ָ���Ļ�����
		# ����
			@AliasFor("cacheNames")
			String[] value() default {};

			@AliasFor("value")
			String[] cacheNames() default {};

			String key() default "";
			String keyGenerator() default "";
			String cacheManager() default "";
			String cacheResolver() default "";
			String condition() default "";
			String unless() default "";
	
	@CacheEvict
		# ��ע����Ҫ�������Ԫ�صķ��������ϵ�
		# �������һ������ʱ��ʾ�������еķ�����ִ�ж��ᴥ��������������
		# ����
			@AliasFor("cacheNames")
			String[] value() default {};
			@AliasFor("value")
			String[] cacheNames() default {};
			String key() default "";
			String keyGenerator() default "";
			String cacheManager() default "";
			String cacheResolver() default "";
			String condition() default "";
			boolean allEntries() default false;
				* ��ʾ�Ƿ���Ҫ��������е�����Ԫ��,Ĭ��Ϊfalse,��ʾ����Ҫ
				* �е�ʱ����ҪCacheһ��������е�Ԫ��,���һ��һ�����Ԫ�ظ���Ч��

			boolean beforeInvocation() default false;
				* �������Ĭ�����ڶ�Ӧ�����ɹ�ִ��֮�󴥷���,�����������Ϊ�׳��쳣��δ�ܳɹ�����ʱҲ���ᴥ���������
				* ������ֵΪtrueʱ��Spring���ڵ��ø÷���֮ǰ��������е�ָ��Ԫ��

	@Caching
		# ���ע��,�Ѷ��ע�����ϵ�һ����
		# ����
			Cacheable[] cacheable() default {};
			CachePut[] put() default {};
			CacheEvict[] evict() default {};
	
	# ʹ���Զ���ע��
		* Spring�������������ÿɻ���ķ���ʱʹ���Զ����ע��
		* ǰ�����Զ����ע���ϱ���ʹ�ö�Ӧ��ע����б�ע
			@Target({ElementType.TYPE, ElementType.METHOD})
			@Retention(RetentionPolicy.RUNTIME)
			@Cacheable(value="users")		//(*^__^*) 
			public @interface MyCacheable {

			}


--------------------
ʹ��redis			|
--------------------
	# ����redis��start(���忴redis�ıʼ�)
		<dependency>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-data-redis</artifactId>
    	</dependency>

	# ����
		spring.cache.type=redis
	
	# ע������
		@Cacheable(value = "name")
			* value ����,ָ����redis ��key����
		

--------------------
Ehcache3			|
--------------------
	# ����
		<dependency>
		    <groupId>org.ehcache</groupId>
		    <artifactId>ehcache</artifactId>
		</dependency>
		<dependency>
		    <groupId>javax.cache</groupId>
		    <artifactId>cache-api</artifactId>
		</dependency>

	# ����
		spring.cache.type=jcache
		spring.cache.jcache.config=classpath:ehcache/ehcache.xml
	
	# ע������
		@Cacheable(value = "name")
			* value����,����ָ���� ehcache.xml �е� <cache alias="name">
	

-----------------------------
CachingConfigurerSupport	 |
-----------------------------
	# �Զ��建���е�һЩ����
		* �̳�:CachingConfigurerSupport,��д����

			import java.lang.reflect.Method;
			import org.springframework.cache.annotation.CachingConfigurerSupport;
			import org.springframework.cache.annotation.EnableCaching;
			import org.springframework.cache.interceptor.KeyGenerator;
			import org.springframework.context.annotation.Configuration;
			/**
			 * 
			 * @author KevinBlandy
			 *
			 */
			@EnableCaching
			@Configuration
			public class RedisCacheConfiguration extends CachingConfigurerSupport{

				//�Զ���key���ɲ���
				@Override
				public KeyGenerator keyGenerator() {
					KeyGenerator generator = new KeyGenerator() {
						@Override
						public Object generate(Object target, Method method, Object... params) {
							return target.getClass().getSimpleName() + ":" + method.getName();
						}
					};
					return generator;
				}
			}
	