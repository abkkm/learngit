----------------------------------
EurekaCient-��ȡ�����ṩ�ߵ�IP�˿�|
----------------------------------

	@Autowired
	private EurekaClient discoverClient
	/**
		��ȡָ�����Ƶķ����ṩ�ߵ�IP��ַ�Ͷ˿�
	*/
	public String serviceUrl(){
		InstanceInfo instance = discoverClient.getNextServerFromEureka("SERVICE-USER",false);
		return instance.getHomePageUrl();
	}