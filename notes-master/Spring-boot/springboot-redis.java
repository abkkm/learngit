------------------------------------
Redis-���ϵ�����					|
------------------------------------
	# ����
		<dependency>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-data-redis</artifactId>
    	</dependency>
	
	# �����ļ�
		# Redis���ݿ�������Ĭ��Ϊ0��
		spring.redis.database=0  
		# Redis��������ַ
		spring.redis.host=192.168.0.58
		# Redis���������Ӷ˿�
		spring.redis.port=6379  
		# Redis��������������(Ĭ��Ϊ��)
		spring.redis.password=  
		# ���ӳ����������(ʹ�ø�ֵ��ʾû������)
		spring.redis.pool.max-active=8  
		# ���ӳ���������ȴ�ʱ��(ʹ�ø�ֵ��ʾû������)
		spring.redis.pool.max-wait=-1  
		# ���ӳ��е�����������
		spring.redis.pool.max-idle=8  
		# ���ӳ��е���С��������
		spring.redis.pool.min-idle=0  
		# ���ӳ�ʱʱ��(����)
		spring.redis.timeout=2000
	# ʹ��
		* StringRedisTemplate
			* ��RedisTemplate������
			* һ����������ʹ����
		* ���jedis�ͻ����д���api�����˹����װ,��ͬһ���Ͳ�����װΪoperation�ӿ�
			ValueOperations	��K-V����
			SetOperations	set�������ݲ���
			ZSetOperations	zset�������ݲ���
			HashOperations	���map���͵����ݲ���
			ListOperations	���list���͵����ݲ���
		* demo
			@Autowired
			private StringRedisTemplate stringRedisTemplate;

			stringRedisTemplate.opsForValue();		//��ȡ������k-v��api
			stringRedisTemplate.opsForSet();		//��ȡ����set��api
	
		
			
------------------------------------
Redis-���ϼ�Ⱥ						|
------------------------------------	
	
	
	