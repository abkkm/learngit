----------------------------
����						|
----------------------------
	# ����
		http://www.ehcache.org/	

	# �ص�
		����
		��
		���ֻ������
		��������������:�ڴ�ʹ���,������赣����������
		�������ݻ�������������Ĺ�����д�����
		����ͨ��RMI,�ɲ���API�ȷ�ʽ���зֲ�ʽ����
		���л���ͻ���������������ӿ�
		֧�ֶ໺�������ʵ��,�Լ�һ��ʵ���Ķ����������
		�ṩHibernate�Ļ���ʵ��
	
	# ����
		* ���Ե���ʹ��.һ���ڵ��������б��õ��ıȽ϶�(��mybatis,shiro��)
		* ehcache �Էֲ�ʽ֧�ֲ�����,����ڵ㲻��ͬ��,ͨ����redisһ��ʹ��
	

	# �����ļ�
		* Ĭ�������Ehcache���Զ�����classpath��Ŀ¼����Ϊehcache.xml�ļ�
		* Ҳ���Խ����ļ��ŵ������ط���ʹ��ʱָ���ļ���λ��


----------------------------
������ʽ��ʼ��				|
----------------------------
	//CacheConfiguration,��������Cache
	CacheConfigurationBuilder<Long, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class,String.class, ResourcePoolsBuilder.heap(10));
	
	//����cacheManagerBuilder
	CacheManagerBuilder<?> cacheManagerBuilder = CacheManagerBuilder.newCacheManagerBuilder();
	
	//ͨ��build()������ȡcacheManagerʵ������,build()�������Դ���һ��boolֵ,��ʾ�Ƿ�������ʼ��cacheManager
	CacheManager cacheManager = cacheManagerBuilder.build();
	
	//��ʼ��cacheManagerʵ��
	cacheManager.init();
	
	//ͨ��cacheManager�����µ�cache����
	Cache<Long, String> myCache = cacheManager.createCache("myCache", cacheConfigurationBuilder);
	
	//���������һ��ֵ
	myCache.put(1L, "da one!");
	
	//�ӻ����ȡһ��ֵ
	String value = myCache.get(1L);
	
	System.out.println(value);

	//ɾ�� Cache,���Ὣ��ر�,Cache�ͷ����б��ر����˲̬��Դ(���ڴ�),��Cache��ò�����
	cacheManager.removeCache("preConfigured");

	//�ر�cacheManager
	cacheManager.close();

----------------------------
�����ļ���ʽ��ʼ��			|
----------------------------
	//�����ļ���ַ
	URL url = Main.class.getResource("/ehcache.xml");
	
	//ʵ����xml���ö���
	Configuration xConfiguration = new XmlConfiguration(url);
	
	//����xml���ö��󴴽�CacheManager
	CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xConfiguration);
	
	//��ʼ��cacheManager
	cacheManager.init();
	
	//��ȡָ�����Ƶ�cache
	Cache<String, String> cache = cacheManager.getCache("foo", String.class, String.class);
	
	cache.put("1", "KevinBlandy");
	System.out.println(cache.get("1"));
	cache.remove("1");
	
	//��cacheManager�Ƴ�cache,���Ǹ�cache�����Ա�������CacheManagerʹ��
	cacheManager.removeCache("foo");
	
	//�ر�cacheManager,��ʵ����Closeable�ӿ�
	cacheManager.close();

----------------------------
�洢��						|
----------------------------
	# ���빹��
		//���� ResourcePoolsBuilder
		ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder();

		/**
			���Խ���ʹ��һ�����͵� resourcePoolsBuilder,����:����ʹ�û����е�����ֻ����offheap(����)��ʹ��
			Ҳ����������һ�����
		**/

		resourcePoolsBuilder = resourcePoolsBuilder.heap(10, EntryUnit.ENTRIES);		//�Ѵ洢���Կ���
		resourcePoolsBuilder = resourcePoolsBuilder.offheap(1, MemoryUnit.MB);			//����洢���Կ���
		resourcePoolsBuilder = resourcePoolsBuilder.disk(20, MemoryUnit.MB, true);		//Ӳ�̴洢���Կ���
		
		//���� cacheConfigurationBuilder
		CacheConfigurationBuilder<Long, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, resourcePoolsBuilder);
		
		//���� CacheConfigurationBuilder
		CacheManagerBuilder<CacheManager> cacheManagerBuilder = CacheManagerBuilder.newCacheManagerBuilder();
		
		//���� persistentCacheManagerBuilder
		CacheManagerBuilder<PersistentCacheManager> persistentCacheManagerBuilder = cacheManagerBuilder.with(CacheManagerBuilder.persistence(new File("e:\\ehcache", "myData")));
		
		//���� PersistentCacheManager
		PersistentCacheManager persistentCacheManager = persistentCacheManagerBuilder.build(true);
		
		//ʹ�� cacheConfigurationBuilder ���� cache
		Cache<Long,String> cache = persistentCacheManager.createCache("foo", cacheConfigurationBuilder);
		
		cache.put(1L, "KevinBlandy");
		
		System.out.println(cache.get(1L));
	
	# ����
		1,����
		2,����
		3,����
		4,��Ⱥ(���Ƽ�)

		* �������ڶ��������,����ʵ�����л��ӿ�
	
		* ���зֲ�ѡ����Ե���ʹ��,����,����ʹ�û����е�����ֻ����offheap��ʹ��
			CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(2, MemoryUnit.GB)).build(); 
	
	# �Ѳ�
		* ÿ����������,Ҳ�Ǹ����,��Ϊ����Ҫ���л�
		* ���԰���Ŀ�򰴴�С�����Ѳ�Ĵ�С
			ResourcePoolsBuilder.newResourcePoolsBuilder().heap(10, EntryUnit.ENTRIES);			//����ֻ������10����Ŀ
			ResourcePoolsBuilder.newResourcePoolsBuilder().heap(10);							//����ֻ������10����Ŀ(Ĭ��)
			ResourcePoolsBuilder.newResourcePoolsBuilder().heap(10, MemoryUnit.MB);				//ֻ����10 MB

	# ����
		* ʹ�ö���,���붨��һ����Դ��,������Ҫ������ڴ��С
			ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(10, MemoryUnit.MB);	//ֻ��10MB��С
		* �������ݱ��뱻���л��ͷ����л� - ��˱ȶѸ���
		* �����ڶѴ���������,��Щ���ݶ��ϵ������ռ�,����̫���ص�Ӱ��(�������ᱻGC)
		* -XX:MaxDirectMemorySize:���ݴ���ʹ�õĶ����С,��Ҫ������javaѡ���ж����ѡ��
	
	# ���̲�
		* ���ݴ洢�ڴ�����,����Խ��,Խר��,�������ݵ��ٶȾ�Խ��
			PersistentCacheManager persistentCacheManager = CacheManagerBuilder.newCacheManagerBuilder() 
				.with(CacheManagerBuilder.persistence(new File(getStoragePath(), "myData"))) 
				.withCache("persistent-cache", CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
					ResourcePoolsBuilder.newResourcePoolsBuilder().disk(10, MemoryUnit.MB)) 
				).build(true);
			persistentCacheManager.close();
		
		* ���ô������ô洢,Ĭ�Ϸ�����
			ResourcePoolsBuilder.newResourcePoolsBuilder().disk(10, MemoryUnit.MB, true)
		
		* ���̲㲻���ڻ��������֮�乲��,�־���Ŀ¼��ʱר����һ�����ٻ��������

		* Ehcache 3���������رյ�������ṩ�־���
			* ����ִ���� CacheManager�� close() api
			* ���JVM����,�򲻴������������Ա�֤
			* ����������ʱ,Ehcache���⵽��CacheManagerû����ȫ�ر�,����ʹ��֮ǰ�������̴洢��
		
		* ���̴洢��Ϊ�����,�ṩ��������,��Ҳ����򿪵��ļ�ָ��,ȱʡֵ��16
		* ��ĳЩ�����,����ϣ��ͨ�����ٶε����������Ͳ����Բ���ʡ��Դ

			ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder();
			resourcePoolsBuilder = resourcePoolsBuilder.disk(20, MemoryUnit.MB, true);
			
			CacheConfigurationBuilder<Long, String> cacheConfigurationBuilder = CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, resourcePoolsBuilder);
			//���÷ֶδ�С
			cacheConfigurationBuilder.add(new OffHeapDiskStoreConfiguration(2));
		
		
	# �������
		* ʹ�ö�����,��һЩ����
			1,�ڶ�������б���ʼ����һ���Ѳ�
			2,�����ܺϲ����̲�ͼ�Ⱥ��
			3,�㼶�Ĵ�СӦ���ǽ������ε�,Ҳ����˵�������㼶Խ��,�㼶Խ��
		
		* ����֮��Ĵ�С��ϵ:���ڴ��С < �����ڴ��С < ���̴�С
	
	# ��Դ��
		* ���ʹ����Դ�ؽ�������,�����ʱ��ʹ��һ��ResourcePoolsBuilder
			ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder();
			//���ڴ������
			resourcePoolsBuilder = resourcePoolsBuilder.heap(10, EntryUnit.ENTRIES);
			//�����ڴ�����
			resourcePoolsBuilder = resourcePoolsBuilder.offheap(1, MemoryUnit.MB);
			//��������
			resourcePoolsBuilder = resourcePoolsBuilder.disk(20, MemoryUnit.MB, true);

			CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, resourcePoolsBuilder);

			* ʹ��3��Ļ���(��,offheap,����)���Ǵ���������ʹ�� ResourcePoolsBuilder ����˳���޹ؽ�Ҫ(����offheap�����ڶ�֮ǰ����)
		
		* ��Դ��'������ָ������',�����ǿ����ڻ���֮�乲���ʵ�ʳ�
			ResourcePools pool = ResourcePoolsBuilder.newResourcePoolsBuilder().heap(10).build();
			CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
			  .withCache("test-cache1", CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, String.class, pool))
			  .withCache("test-cache2", CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, String.class, pool))
			  .build(true);
			
			* test-cache1��test-cache2������������
		
		* ����ResourcePools
			* updateResourcePools()������ĶѲ��С,�����ǳ�����
			* ���,'���ܸ��Ķ�������̲�Ĵ�С'

				ResourcePools pools = ResourcePoolsBuilder.newResourcePoolsBuilder().heap(20L, EntryUnit.ENTRIES).build(); 

				cache.getRuntimeConfiguration().updateResourcePools(pools); 

				assertThat(cache.getRuntimeConfiguration().getResourcePools()
				  .getPoolForResource(ResourceType.Core.HEAP).getSize(), is(20L));
	
	# �ݻ�
		* ����ʹ���,������������,����ζ�ŵ�JVMֹͣʱ,���д����Ļ��漰�������Դ����ڴ��̻�Ⱥ����
		* ��Ҫ��ȫɾ������,���ǵĶ��� PersistentCacheManager �ṩ�����·���
			destroy()
				* �˷��������뻺���������ص���������(��Ȼ��������)
				* �������������رջ�δ��ʼ�����ܵ��ô˷���
				* ����,����Ⱥ����,��ǰû���������������Ӧ�����ӵ���ͬ�Ļ��������������ʵ��

			destroyCache(String cacheName)
				* �˷������ٸ����Ļ���,�û��治Ӧ�ñ���һ�����������ʹ��
			


	# ��㻺�������˳������
		1,���򻺴������һ��ֵʱ������ֱ�ӽ�����Ͳ����Ȩ�㡣
		2,��������get�����ڻ�������������͸�ֵ��
		3,��Ȼ��ֻҪ��Ȩ������ֵ�����и��߼���Ļ���㶼��ʧЧ��
		4,��ȫ����δ���У���ֵ�����κβ��ϣ�ʼ�ջ�һֱ���쵽��Ȩ�㡣


----------------------------
�ܽ�						|
----------------------------
	