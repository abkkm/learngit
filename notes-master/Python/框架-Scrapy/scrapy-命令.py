----------------------------
��������					|
----------------------------
	* Scrapy Ĭ���� scrapy.cfg �ļ��в������ò���(���ȼ���ӵ͵���)

		ϵͳ��Χ	/etc/scrapy.cfg �� c:\scrapy\scrapy.cfg
		�û���Χ	~/.config/scrapy.cfg ($XDG_CONFIG_HOME)  ��  ~/.scrapy.cfg ($HOME)
		��Ŀ�ڷ�Χ	scrapy.cfg

		* ��Ŀ��Χ�����ý��������������ļ�������,�û���Χ�ڶ�������õĸ���ϵͳ��Χ�ڵ�����

	* Scrapy Ҳ���Խ������Ի������������á�Ŀǰ��

		SCRAPY_SETTINGS_MODULE (�� Designating the settings)
		SCRAPY_PROJECT
		SCRAPY_PYTHON_SHELL (�� Scrapy shell)

----------------------------
ȫ������					|
----------------------------
	scrapy startproject [name]
		* ����һ��scrapy������Ŀ
		* �����õ�Ŀ¼�ṹ
			name
				|-name
					|-spiders
						|-__init__.,py
					|-__init__.,py
					|-items.py
					|-middlewares.py
					|-pipelines.py
					|-settings.py
				|-scrapy.cfg
	
	
	scrapy genspider [name] [url]
		* ����һ��ָ��name������,Ŀ���ַ��url
	
	scrapy settings
	scrapy runspider
	scrapy shell
	scrapy fetch
	scrapy view
	scrapy version

----------------------------
��Ŀ����					|
----------------------------
	scarpy crawl [name]
		* ��ʼ����ָ�����Ƶ�����
		* ����
			-o
				* ��spider��parse�������ص��������л�������
				* -oָ���ļ�������,�������ڵ�ǰ����Ŀ¼
				* ������ .json /.csv /.xml

			


	
	scrapy check
	scrapy list
	scrapy edit
	scrapy parse
	scrapy bench

----------------------------
�Զ�������					|
----------------------------
	* ʵ���Թ���