------------------------
beautifulsoup			|
------------------------
	* ��װ
		pip install beautifulsoup4

	* �ĵ�
		http://beautifulsoup.readthedocs.io/zh_CN/latest/
	

------------------------
beautifulsoup-��ʼ����	|
------------------------
	from bs4 import BeautifulSoup
	
	# ���Դ���html�ļ�
	soup = BeautifulSoup(open("index.html"),'html.parser')
	
	# ����ֱ�ӹ���html�ַ���
	soup = BeautifulSoup("<html>data</html>",'html.parser')

--------------------------
beautifulsoup-�����Ĵ����|
--------------------------
	tag
		* ��ʾ��ǩ

	NavigableString
		* ��ʾ��ǩ��

	BeautifulSoup
		* ��ʾ����html�ĵ�����

	Comment
		* ��ʾע��<!--ע��-->
		* ������ NavigableString ������
	
	* ����һЩ�����Ķ���
		CData 
			* xml�е� <![CDATA[]]>
		ProcessingInstruction 
		Declaratio
		Doctype 
			* HTML�е� <!DOCTYPE html>
		