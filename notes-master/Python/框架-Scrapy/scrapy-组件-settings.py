--------------------------------
settings						|
--------------------------------
	* ����ģ��
--------------------------------
settings-ģ��������				|
--------------------------------

	BOT_NAME = 'webspider'
		* ��������,Ҳ������Ŀ����
	
	LOG_FILE = 'my.log'
		* ָ����־����ļ�
	
	LOG_LEVEL = 'WARNING'
		* ָ����־�������
			'CRITICAL': CRITICAL,
			'FATAL': FATAL,
			'ERROR': ERROR,
			'WARN': WARNING,
			'WARNING': WARNING,
			'INFO': INFO,
			'DEBUG': DEBUG,

	SPIDER_MODULES = ['webspider.spiders']

	NEWSPIDER_MODULE = 'webspider.spiders'


	USER_AGENT = 'webspider (+http://www.yourdomain.com)'

	ROBOTSTXT_OBEY = True
		* �����Ƿ�Ҫ��ѭ robots Э��

	CONCURRENT_REQUESTS = 32
		* ���沢��,��������ͬʱ���������,Ĭ��:16

	DOWNLOAD_DELAY = 3
		* �����ӳ�,��λ����

	CONCURRENT_REQUESTS_PER_DOMAIN = 16
	CONCURRENT_REQUESTS_PER_IP = 16

	COOKIES_ENABLED = False
		* �Ƿ�����cookie����,Ĭ�Ͽ���

	TELNETCONSOLE_ENABLED = False

	DEFAULT_REQUEST_HEADERS = {
	   'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
	   'Accept-Language': 'en',
	}
		* Ĭ�ϵ�http����ͷ,�������:'User-Agent',����ƭ������

	SPIDER_MIDDLEWARES = {
		'webspider.middlewares.WebspiderSpiderMiddleware': 543,
	}
		* �����м��,�����ֵ��ʾ���ȼ�,��ֵԽС,���ȼ�Խ��

	DOWNLOADER_MIDDLEWARES = {
		'webspider.middlewares.MyCustomDownloaderMiddleware': 543,
	}
		* �����м��,�����ֵ��ʾ���ȼ�,��ֵԽС,���ȼ�Խ��

	EXTENSIONS = {
		'scrapy.extensions.telnet.TelnetConsole': None,
	}

	ITEM_PIPELINES = {
		'webspider.pipelines.WebspiderPipeline': 300,
	}
		* �ܵ��ļ�,���Ǿ��������غõ��������������,�����ֵ��ʾ���ȼ�,��ֵԽС,���ȼ�Խ��

	AUTOTHROTTLE_ENABLED = True
	AUTOTHROTTLE_START_DELAY = 5
	AUTOTHROTTLE_MAX_DELAY = 60
	AUTOTHROTTLE_TARGET_CONCURRENCY = 1.0
	AUTOTHROTTLE_DEBUG = False
	HTTPCACHE_ENABLED = True
	HTTPCACHE_EXPIRATION_SECS = 0
	HTTPCACHE_DIR = 'httpcache'
	HTTPCACHE_IGNORE_HTTP_CODES = []
	HTTPCACHE_STORAGE = 'scrapy.extensions.httpcache.FilesystemCacheStorage'

--------------------------------
settings-�ڳ����л�ȡ������Ϣ	|
--------------------------------
	from scrapy.utils.project import get_project_settings
	
	# ͨ���÷�����ȡָ�����Ƶ�������
	get_project_settings().get('BOT_NAME')

