--------------------------------
beautifulsoup-Tag			 	|
--------------------------------
	* ���tag��ԭ�������������tagһ����˼,����ָ:��ǩ
		from bs4 import BeautifulSoup
		soup = BeautifulSoup(open('index.html'),'html.parser')
		print(soup.a)		# ��ӡ���������½������ĵ�һ��a��ǩ�ַ���
		print(type(soup.a))	# <class 'bs4.element.Tag'>

--------------------------------
beautifulsoup-����			 	|
--------------------------------
	name
		* ������ֵ���ַ���,���ǵ�ǰ��ǩ���ַ�������
		* �����޸ĸ�����,����Ӱ������ͨ����ǰbeautifulsoup���ɵ�HTML�ĵ�
			soup = BeautifulSoup(open('index.html'),'html.parser')
			soup.a.name = 'b'
			print(soup)	# <b href="http://javaweb.io">KevinBlandy2</b>

	attrs
		* ���� dict,�ǵ�ǰ��ǩ����������ֵ
			soup.div.attrs		# {'name': 'name����', 'data-options': 'data-options����', 'id': 'id����'}

		* Ҳ����ֱ����[]��ʽ���з���,������Բ�����,�׳��쳣
			soup.div['class']
			soup.div['data-options']

		* tag������ֵ���Ա��޸�
			soup.div['name'] = '�µ�name����'
			# <div name="�µ�name����">
		
		* tag������ֵ���Ա�ɾ��
			del tag['name']
			# <div><div>
		
		* ������Կ����ж��ֵ(����html��׼),��ô���ص���һ��list
			<div class="c1 c2"></div>
			soup.div.attrs
			# {'class': ['c1', 'c2']}		/  ֻ��һ��ֵҲ��list:{'class': ['c1']}
			
			* ��ֵ����Ҳ������ɾ(���������ò���list�ķ������в���������)
				soup.div.attrs['class'].append('c3')
				# <div class="c1 c2 c3"></div>

				soup.div.attrs['class'].remove('c1')
				# <div class="c2"></div>

			* ���ת�����ĵ���XML��ʽ,��ôtag�в�������ֵ����
				xml_soup = BeautifulSoup('<p class="body strikeout"></p>', 'xml')
				xml_soup.p['class']
				# 'body strikeout'

		* Ҳ����ͨ�� get() ��������ȡ����ֵ,���Բ����ڷ���None
			get(attr)

--------------------------------
beautifulsoup-��ǩ��		 	|
--------------------------------
	* <div>�Ҿ��Ǳ�ǩ��<div>
	* ͨ�� tag.string ����ȡ
		soup.div.string
		# �Ҿ��Ǳ�ǩ��
		* �ᱻ��װΪ:<class 'bs4.element.NavigableString'> ��
	
	* tag�а������ַ������ܱ༭,���ǿ���ͨ�� replace_with() ���滻���������ַ���
		soup.div.string.replace_with('�µı�ǩ��')
		# <div>�µı�ǩ��</div>

		* ��ʵҲ����ֱ���滻
		soup.div.string = '�µı�ǩ��'
	

	

	
	

	

