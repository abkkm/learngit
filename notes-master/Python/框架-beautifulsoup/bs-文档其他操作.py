--------------------
ָ���ĵ�������		|
--------------------


--------------------
����				|
--------------------

	* UnicodeDammit 
		* UnicodeDammit ��BS���ÿ�, ��Ҫ�����²��ĵ�����	
			from bs4 import UnicodeDammit
			dammit = UnicodeDammit("Sacr\xc3\xa9 bleu!")
			print(dammit.unicode_markup)
			# Sacr�� bleu!
			dammit.original_encoding
			# 'utf-8'

		* ���Python�а�װ�� chardet �� cchardet ��ô�����⹦�ܵ�׼ȷ�ʽ�������. 
		* ������ַ�Խ��,�����Խ��ȷ
		* ������Ȳ²⵽һЩ���ܱ���, ��ô���Խ��²�ı�����Ϊ����(list),���������ȼ����Щ����:
			dammit = UnicodeDammit("Sacr\xe9 bleu!", ["latin-1", "iso-8859-1"])
			print(dammit.unicode_markup)
			# Sacr�� bleu!
			dammit.original_encoding
			# 'latin-1'
	
--------------------
�Ƚ϶����Ƿ���ͬ	|
--------------------
	* ���� NavigableString �� Tag ���������ͬ��HTML��XML�ṹʱ, Beautiful Soup���ж�������������ͬ.
		markup = "<p>I want <b>pizza</b> and more <b>pizza</b>!</p>"
		soup = BeautifulSoup(markup, 'html.parser')
		first_b, second_b = soup.find_all('b')
		print (first_b == second_b)
		# True
		print (first_b.previous_element == second_b.previous_element)
		# False
		# 2�� <b> ��ǩ�� BS ������ͬ��, �����������ĵ����Ĳ�ͬλ��, ���Ǿ�����ͬ�ı���: ��<b>pizza</b>��

		print (first_b is second_b)
		# False
		* ������ж����������Ƿ��ϸ��ָ��ͬһ���������ͨ�� is ���ж�

------------------------
����Beautiful Soup����	|
------------------------
	* copy.copy() �������Ը������� Tag �� NavigableString ����

		import copy
		p_copy = copy.copy(soup.p)
		print (p_copy)
		# <p>I want <b>pizza</b> and more <b>pizza</b>!</p>
		# ���ƺ�Ķ�������������ȵ�, ��ָ��ͬ���ڴ��ַ

		print soup.p == p_copy
		# True

		print soup.p is p_copy
		# False

	* Դ����͸��ƶ����������Դ�������ĵ�����, �����ƺ�Ķ����Ƕ����Ļ�û����ӵ��ĵ�����.
	* ���ƺ�����Ч���������� extract() ������ͬ.
		print (p_copy.parent)
		# None
		# ������Ϊ��ȵĶ�����ͬʱ������ͬ��λ��

------------------------
���������ĵ�			|
------------------------
	* SoupStrainer ����Զ����ĵ���ĳ������,���������ĵ�ʱ�Ͳ����Ƚ�����ƪ�ĵ�
	* ֻ������� SoupStrainer �ж�������ĵ�.
	* ����һ�� SoupStrainer ������Ϊ parse_only ������ BeautifulSoup �Ĺ��췽������.
		from bs4 import SoupStrainer
		
		# ��������a��ǩ
		only_a_tags = SoupStrainer("a")	
		
		# ��������id=link2�ı�ǩ
		only_tags_with_id_link2 = SoupStrainer(id="link2")
		
		def is_short_string(string):
			return len(string) < 10
		
		# ���������������� true �ı�ǩ
		only_short_strings = SoupStrainer(string=is_short_string)

		* SoupStrainer ��������������������ͬ�Ĳ���:name , attrs , recursive , string , **kwargs ��
	
	* BeautifulSoup(html_doc, "html.parser", parse_only=only_a_tags)