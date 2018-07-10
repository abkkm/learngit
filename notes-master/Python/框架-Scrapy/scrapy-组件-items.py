------------------------
items					|
------------------------
	* ��ʵ���Ƕ���model
	* �򵥵�model����
		import scrapy
		class WebspiderItem(scrapy.Item):
			name = scrapy.Field()		# ����һ��name����
			age = scrapy.Field()		# ����һ��age����
			gender = scrapy.Field()		# ����һ��gender����
	

------------------------
ItemLoader				|
------------------------	
	* from scrapy.loader import ItemLoader
	* �ṩ��һ�ָ�Ϊ��ݵķ�ʽ��spider�ж� Item �������
	* ���캯��
		ItemLoader(item=None, selector=None, response=None, parent=None, **context)

	* demo
		from scrapy.loader import ItemLoader
		from kevin.items import User

		def parse(self,response):
			# ͨ��Itemʵ����response��ʵ����loader
			loader = ItemLoader(item=User(),response=response)

			# ͨ��xpath��ָ�������Խ��и�ֵ
			loader.add_xpath('name', '//div[@class="product_name"]') 
			loader.add_xpath('name', '//div[@class="product_title"]')
			loader.add_xpath('price', '//p[@id="price"]')

			# ͨ��cssѡ������ָ�������Խ��и�ֵ
			loader.add_css('stock', 'p#stock]')

			# ֱ������ֵ
			loader.add_value('last_updated', 'today') 

			# ��������ֵ��item
			return loader.load_item()