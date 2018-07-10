----------------------------
CrawlSpider					|
----------------------------
	* scrapy.spiders.CrawlSpider
	* Spider����,Spider������ԭ����ֻ��ȡstart_url�б��е���ҳ
	* ��CrawlSpider�ඨ����һЩ����(rule)���ṩ����link�ķ���Ļ���
	* ����ȡ����ҳ�л�ȡlink��������ȡ�Ĺ������ʺ�
		
----------------------------
CrawlSpider-���е�����		|
----------------------------	
	rules
		* ���� Rule ����,���ڶ�����ȡurl�Ĺ���
	
-----------------------------
LinkExtractor				 |
-----------------------------
	* ���ڴ�html�ṹ������ȡ������
	* from scrapy.linkextractors import LinkExtractor
	* ���캯��
		LinkExtractor(allow=(), deny=(), allow_domains=(), deny_domains=(), restrict_xpaths=(),
                 tags=('a', 'area'), attrs=('href',), canonicalize=False,
                 unique=True, process_value=None, deny_extensions=None, restrict_css=(),
                 strip=True)
			allow
				* ��ʾƥ��Ĺ���(����href����),��һ�����߶��������ʽ(Ԫ��)
				* �����ֵΪ��,�����е����Ӷ��ᱻ��ȡ
			deny
				* Ҳ��һ���������,�ù������е�����,���ᱻ��ȡ
			allow_domains
				* �ᱻ��ȡ��������
			deny_domains
				* ���ᱻ��ȡ��������
			restrict_xpaths
				* ʹ��xpath���ʽ,��allow��ͬ��������

	* ���� & ����
		extract_links(response)
			* ������Ӧ����,����link����,���� Link ���󼯺�
	* demo
		def parse(self, response):
			# ���� extrator ����(ƥ�����)
			extrator = LinkExtractor(allow=('start=\d+',))
			# ͨ�� extract_links ������ response ����,��ȡLink���󼯺� 
			links = extrator.extract_links(response)
			for i in links:
				print(i)	# Link(url='http://hr.tencent.com/position.php?tid=87&start=10#a', text='2', fragment='', nofollow=False)

-----------------------------
Rule						 |
-----------------------------
	* ���ڶ�����ôȥ����ƥ�䵽������
	* һ�� Rule ��������һ��ƥ�����(LinkExtractor),����������԰������ Rules
	* ������ Rule ƥ������ͬ������,����ݹ����ڼ����еĶ���˳��,��һ�����ᱻʹ��
	* from scrapy.spiders import Rule
	* ���캯��
		Rule(link_extractor, callback=None, cb_kwargs=None, follow=None, process_links=None, process_request=identity)
			link_extractor
				* ��ʾһ��ƥ�����(LinkExtractor)
			callback
				* �ص�������(str),ÿ����link_extractor�л�ȡ�����ӵ�ʱ��,������Ϊ�������ݸ��ûص�����
				* ע��,�ú������Ʋ�����'parse'��ͻ
			follow
				* bool ֵ,ָ���˸��ݸù�����ȡ�����������Ƿ�Ҫ����(������,�����ȡ)
				* ��� callback = None,��ֵĬ��Ϊ True,�����ֵΪ False
			process_links
				* ��str��ʽ,ָ��spider���ĸ��������ᱻ����,��ƥ�����(LinkExtractor)�л�ȡ�������б�
				* ���Ǵ�����ȡ�������ӵķ���,������Ϻ󷵻������б�
	
		
-----------------------------
Spider-demo					 |
-----------------------------
		
	from job import items
	from scrapy.linkextractors import LinkExtractor
	from scrapy.spiders import Rule
	from scrapy.spiders import CrawlSpider

	# ������Ӹ���
	class JobSpider(CrawlSpider):
		name = 'job'
		allowed_domains = ['hr.tencent.com']
		start_urls = ['http://hr.tencent.com/position.php']

		# url��ȡ����
		rules = [
			# ������һ��url����,����,�ص�����,�Ƿ�Ҫ��������
			Rule(LinkExtractor(allow = r'start=\d+'),callback = 'parseLink',follow = True)
		]

		# ����ص�
		def parseLink(self,response):
			trs = response.xpath("//tr[@class='even'] | //tr[@class='odd']")
			for i in trs:
				job = items.JobItem()
				job['name'] = i.xpath("./td/a/text()").extract()
				job['href'] = i.xpath("./td/a/@href").extract()
				job['type_'] = i.xpath('./td[2]/text()').extract()
				job['count'] = i.xpath('./td[3]/text()').extract()
				job['address'] = i.xpath('./td[4]/text()').extract()
				job['time'] = i.xpath('./td[5]/text()').extract()
				yield job