-----------------------------
spiders						 |
-----------------------------
	* spider Ӧ�ó����� spiders pythonĿ¼��
	* spider ����̳���:scrapy.Spider
	* spider��parseҪô���� item,Ҫô���� Request,��˼��Ҫô��������,Ҫô������

-----------------------------
spiders-��Ҫ�����Ժͷ���	 |
-----------------------------
	name
		* ����spider���ֵ��ַ���
		* ����,���spider��ȡ mywebsite.com ,��spiderͨ���ᱻ����Ϊ mywebsite

	allowed_domains
		* ������spider������ȡ������(domain)���б�,��ѡ

	start_urls
		* ��ʼURLԪ��/�б�,��û���ƶ��ض���URLʱ,spider���Ӹ��б��п�ʼ������ȡ
		* Ҳ������ 

	start_requests(self)
		* �÷������뷵��һ�� Request ʵ���Ŀɵ�������(iterable),�ö��������spider������ȡ�ĵ�һ��Request
		* ��ʵԴ���о��Ƕ� start_urls �е�url���Խ��е���,���� parse Ϊ�ص��������� Request

	parse(self, response)
		* ������url������ҳû��ָ���ص�����ʱ,Ĭ�ϵ�Request����ص�����
		* ����������ҳ���ص�response,�Լ�����Item����Request����

	log(self, message[, level, component])
		* ʹ�� scrapy.log.msg() ������¼(log)message
		* ����������μ� logging
	
	closed(reason)
		* ��spider�ر�ʱ,�ú���������
		* �÷����ṩ��һ��������� signals.connect()������ spider_closed �źŵĿ�ݷ�ʽ

-----------------------------
����spiders	����			 |
-----------------------------
	import scrapy
	class ItcastSpider(scrapy.Spider):

		# ָ�����������
		name = 'itcast'

		# ������ȡ����
		allowed_domains = ['itcast.cn']

		# ��ʼ�ĵ�ַ
		start_urls = ['http://itcast.cn/']

		# ��ȡ�������(self���Է����������������,�Լ��Զ��������)
		def parse(self, response):	
			response.url				# ��ȡʱ�����url
			response.body				# ���ص�html
			response.body_as_unicode()	# ���ص�html unicode����
		
		* name,allowed_domains ������,���ǵ�ǰSpiderʵ������(����ͨ�� self ����)
		
-----------------------------
spiders	���·�������		 |
-----------------------------
	* ����ȡ������,�������Ӧ����ȡ��������,��Ҫ�����ȡ,�򷵻� scrapy.Request() ʵ������

		def parse(self, response):	
			...
			# ����������,����pipe����
			yield item

			...
			# ������url,���·��͸�������,�����,����ָ���ص�����,���ǵ�ǰ����
			yield scrapy.Request('http://....com',callback=self.parse)
	
	* scrapy.Request(url, callback=None, method='GET', headers=None, body=None,
                 cookies=None, meta=None, encoding='utf-8', priority=0,
                 dont_filter=False, errback=None, flags=None)
		* ��һ������,������ȡ������url
		* �ؼ��ֲ���
			callback
				* ������Ӧ��,��˭���д���(�ص�����)

-----------------------------
Selectorsѡ����				 |
-----------------------------
	* response.selector,����ȡ��һ�� response ��ʼ������ Selector �Ķ���
	* ͨ��ʹ�� response.selector.xpath()��response.selector.css() ���� response ���в�ѯ
	* ScrapyҲ�ṩ��һЩ��ݷ�ʽ�����з���
		response.xpath
		response.css()
	
	* Scrapy Selectors ���� XPath �� CSS Selector ���ʽ����

	* Selector���ĸ������ķ���,��õĻ���xpath

		xpath()		
			* ����xpath���ʽ,���ظñ��ʽ����Ӧ�����нڵ��selector list�б�
		extract()	
			* ���л��ýڵ�ΪUnicode�ַ���������list
		css()		
			* ����CSS���ʽ,���ظñ��ʽ����Ӧ�����нڵ��selector list�б�,�﷨ͬ BeautifulSoup4
		re()		
			* ���ݴ����������ʽ�����ݽ�����ȡ,����Unicode�ַ���list�б�
		extract_first()
			* �� extract() ������л�ȡ��һ��Ԫ��,���õ�������Խ���쳣,�����ڷ��� None
	
------------------------------------
�����������						|
------------------------------------
	* ����������ʱ,����ͨ�� -a ѡ��Ϊ�����ṩ�����в���
		scrapy crawl quotes -o quotes-humor.json -a tag=humor

	* Ĭ�������,��Щ���������ݸ� Spider �� __init__ ��������Ϊ���������
		 tag = getattr(self, 'tag', None)	# ͨ�������ȡִ�����洫�ݵĲ���

	
------------------------------------
Response							|
------------------------------------
	* �ɿ�ܹ���
	* ����
		url				# ��ȡʱ�����url
		body			# ����http��Ӧ��

	* ����
		body_as_unicode()	# ���ص�html unicode����
		urljoin()
		follow()
			* ����һ�� Request ʵ������

------------------------------------
Request								|
------------------------------------
	* ���Լ�����,��ʾһ��http�������
	* ���캯��
		Request(url, callback=None, method='GET', headers=None, body=None,
                 cookies=None, meta=None, encoding='utf-8', priority=0,
                 dont_filter=False, errback=None, flags=None)
		
		* ��һ������,����Ŀ��url
		* �ؼ��ֲ���
			callback
				* ������Ӧ��,��˭���д���(�ص�����)