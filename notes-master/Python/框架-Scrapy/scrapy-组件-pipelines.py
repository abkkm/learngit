------------------------
pipelines				|
------------------------
	* Ĭ��Ԥ�������
		class WebspiderPipeline(object):
		def process_item(self, item, spider):
			return item
	
	* �����(ģ��)��������N��� Pipelines 

	* ������settings.py��
		ITEM_PIPELINES = {
		   'webspider.pipelines.WebspiderPipeline': 300,
		}
	
	* Pipelines����ֱ�Ӽ̳���object
	

------------------------
pipelines-����			|
------------------------
	* ����ʵ�ֵĵķ���(�������ݵķ���),�����̶�
		def process_item(self, item, spider):
			return item

		* item,���ݹ���������
		* spider,����ʵ������
	
	* ������رյ�ʱ��,ִ�еķ���,�Ǳ���
		def close_spider(self,spider):
			print("����ر�:%s"%(spider))
		
		* spider,����ʵ������
	
	* �����濪����ʱ��,ִ�еķ���,�Ǳ���
		def open_spider(self, spider):
			print("���濪��:%s"%(spider))
		
		* spider,����ʵ������
	
	* δ֪
		from_crawler(self,crawler)
	


	
------------------------
scrapy.pipelines.images	|
------------------------
	* scrapy.pipelines.images.ImaagePiPeline

	IMAGES_STROE = "/"
	
	def get_media_requests(self,item,info):
		yield scray.Request(item['url'])
	
	def item_completed(self,result,item,info):
		image_path = [x['path'] for ok ,x in result if ok ]
		return item


------------------------
scrapy.pipelines.files	|
------------------------


------------------------
scrapy.pipelines.media	|
------------------------


