------------------------
�ӽڵ�					|
------------------------
	* �����ĵ�����򵥵ķ������Ǹ����������ȡ��tag��name
		soup.head.title
		# ��ȡ�ĵ��� head ��ǩ�µ� titile ��ǩ
		
		* ͨ�����ַ�ʽ,ֻ�ܻ�ȡ��ָ�����Ƶĵ�һ����ǩ
	
	* ��ȡ�ĵ��е����б�ǩ,��Ҫʹ�� find_all(),����list
		soup.find_all('a')
	
	* �������Ի�ȡ�ӽڵ���Ϣ
		contents 
			* ����list,��ǰ��ǩ'����ֱ����Ԫ�ؼ���',�����ı��ڵ�(bs4.element.NavigableString)
			* '�ַ����ڵ�û�и�����'
		
		children 
			* ���ص�����,��ǰ��ǩ��'����ֱ����Ԫ��'
		
		descendants
			* ���ص�ǰ��ǩ��'������Ԫ��'
			* �ݹ�
	
	* ���tagֻ��һ�� NavigableString �����ӽڵ�,��ô���tag����ʹ�� .string �õ��ӽڵ�
		soup.head.title.string

		* ���tagֻ��һ���ӱ�ǩ,���tagҲ����ֱ��ͨ�� .string ��ȡ��Ψһ�ӱ�ǩ�ı�ǩ��
			<head><title>Title</title></head>
			soup.head.string
			# Title
	
	* ͨ�� strings ��ȡ���е����ı���Ϣ,�ݹ��ȡ
		soup.strings

		* ���ص��ǵ�����
		* ʹ�� stripped_strings ���Ժ��Ե����еĿհ���Ϣ


------------------------
���ڵ�					|
------------------------
	* ͨ�� .parent ��������ȡĳ��Ԫ�صĸ��ڵ�
		title = soup.head.title
		title.parent
		# <head><title>Title</title></head>
	
	* �ĵ��ڵ�,Ҳ�и��ڵ�����
		title = soup.head.title.string
		title.parent
		# <title>Title</title>
	
	* �ĵ��Ķ���ڵ����<html>�ĸ��ڵ��� BeautifulSoup ����
		html_tag = soup.html
		type(html_tag.parent)
		# <class 'bs4.BeautifulSoup'>
	
		* BeautifulSoup ����� .parent ��None:
		print(soup.parent)
		# None
	
	* ͨ��Ԫ�ص� .parents ���Կ��Եݹ�õ�Ԫ�ص����и����ڵ�
		for i in soup.a.parents:
			print(i.name)
		
		#div
		# body
		# html
		# [document]

------------------------
�ֵܽڵ�				|
------------------------
	* ʹ�� .next_sibling �� .previous_sibling ��������ѯ�ֵܽڵ�
		title = soup.head.title
		meta = soup.head.meta
		print(title.next_sibling)
		print(meta.previous_sibling)

		# <meta charset="utf-8"/>
		# <title>Title</title>
		
		* title û����һ���ֵܱ�ǩ,metaû����һ���ֵܱ�ǩ,ǿ�л�ȡ���� None
		* �հ�/����Ҳ�ᱻ����Ϊ�ڵ�
	
	* ͨ�� .next_siblings �� .previous_siblings ��ȡ���е��ֵܽڵ�,���ص�����
		for i in soup.head.title.next_siblings:
			print(i)
		
------------------------
���˺�ǰ��				|
------------------------
	* ͨ�� .next_element �� .previous_element ��������/��һ���������Ľڵ�
	* ͨ�� .next_elements �� .previous_elements ��������/�±�����������,����һ��������
	
	* �����е����ӽڵ�,ʵ�ʴ�ͬ.
	* <html><body><body></html>  -> <body></body>



		


				

	
		
		
