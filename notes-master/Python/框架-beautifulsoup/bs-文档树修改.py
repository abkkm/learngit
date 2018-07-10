----------------------------
�޸�tag�����ƺ�����			|
----------------------------
	* ֱ���޸������Ժͱ�ǩ����
		soup = BeautifulSoup('<b class="boldest">Extremely bold</b>')
		tag = soup.b

		# �޸ı�ǩ������
		tag.name = "blockquote"
		# �޸ı�ǩ��class����ֵ
		tag['class'] = 'verybold'
		# �޸ı�ǩ��idֵ
		tag['id'] = 1
		# ��ǩ�Ѿ����޸�
		# <blockquote class="verybold" id="1">Extremely bold</blockquote>
		
		# ɾ��ָ��������ֵ
		del tag['class']
		del tag['id']
		# ��ǩ�����Ѿ���ɾ��
		# <blockquote>Extremely bold</blockquote>
	
	* �޸� .string
		soup = BeautifulSoup('<a href="http://example.com/">I linked to <i>example.com</i></a>')
		tag = soup.a
		# �޸�a��ǩ�е��ı��ڵ�
		tag.string = "New link text."
		# �ı��ڵ��Ѿ����޸�
		# <a href="http://example.com/">New link text.</a>

		* �����ǰ��tag����������tag,��ô������ .string ���Ը�ֵ�Ḳ�ǵ�ԭ�е��������ݰ�����tag
	
	* ʹ�� append() ����ı��ڵ������
		soup = BeautifulSoup("<a>Foo</a>")
		# ��a��ǩ���ı��ڵ��������
		soup.a.append("Bar")
		
		# a��ǩ�е��ı��ڵ��Ѿ����
		# <html><head></head><body><a>FooBar</a></body></html>
		soup.a.contents
		# [u'Foo', u'Bar'] //û��ͨ,Ϊɶ����[]��ʽ����

		* append() �Ĳ���Ҳ������ NavigableString() �����������ʵ������
			soup.a.append(NavigableString("bar"))

	* ���ע��
		from bs4 import Comment
		# ����ע�Ͷ���,ע��ڶ���������ʾ��һ��ע��
		new_comment = soup.new_string("Nice to see you.", Comment)
		# ��ӵ��ڵ�
		tag.append(new_comment)
		print(tag)
		# <b>Hello there<!--Nice to see you.--></b>
		print(tag.contents)
		# ['Hello', ' there', 'Nice to see you.']
	
	* ͨ�� new_tag() ���tag 
		soup = BeautifulSoup("<b></b>")
		# ��ȡb��ǩ
		original_tag = soup.b
		
		# �����µ�a��ǩ,���ҳ�ʼ�� href ����
		new_tag = soup.new_tag("a", href="http://www.example.com")
		# ���a��ǩ��b��ǩ��
		original_tag.append(new_tag)
		print(original_tag)
		# <b><a href="http://www.example.com"></a></b>
		# �޸�a��ǩ���ı��ڵ�ֵ
		new_tag.string = "Link text."
		print(original_tag)
		# <b><a href="http://www.example.com">Link text.</a></b>

		* new_tag() ��һ��������Ϊtag��name,�Ǳ���,��������ѡ��
				
	* ͨ�� insert() �����µ�Ԫ��
		markup = '<a href="http://example.com/">KevinBlandy<i>example.com</i></a>'
		soup = BeautifulSoup(markup, "html.parser")
		tag = soup.a
		
		# ��a��ǩ����һ���ı��ڵ�
		tag.insert(1, "Python Developer")
		print(tag)
		# <a href="http://example.com/">KevinBlandyPython Developer<i>example.com</i></a>
		print(tag.contents)
		# ['KevinBlandy', 'Python Developer', <i>example.com</i>]
	
	* insert_before() �� insert_after()�ڽڵ�֮ǰ/֮������µ�Ԫ��
		soup = BeautifulSoup("<b>stop</b>")
		# ����i�ڵ�
		tag = soup.new_tag("i")
		# ����i�ڵ���ı�����
		tag.string = "Don't"
		# ��b�ڵ���ı��ڵ�֮ǰ����i�ڵ�
		soup.b.string.insert_before(tag)
		print(soup.b)
		# <b><i>Don't</i>stop</b>
		
		# ��b�ڵ��µ�i�ڵ�֮�����һ�� ever �ı��ڵ�
		soup.b.i.insert_after(soup.new_string(" ever "))
		print(soup.b)
		# <b><i>Don't</i> ever stop</b>
		print(soup.b.contents)
		# [<i>Don't</i>, u' ever ', u'stop']
	
	* ʹ�� clear() �����Ƴ���ǰtag���ı�����
		markup = '<a href="http://example.com/">I linked to <i>example.com</i></a>'
		soup = BeautifulSoup(markup)
		tag = soup.a
	
		tag.clear()
		print(tag)
		# <a href="http://example.com/"></a>		//a��ǩ֮�е��ı������Ѿ��������
	
	* ʹ�� extract()��������ǰtag�Ƴ��ĵ���,����Ϊ�����������

		markup = '<a href="http://example.com/">I linked to <i>example.com</i></a>'
		soup = BeautifulSoup(markup)
		a_tag = soup.a
		
		# �Ƴ�i��ǩ,���ҷ���
		i_tag = soup.i.extract()
		print(a_tag)
		# <a href="http://example.com/">I linked to</a>	//i��ǩ�Ѿ����Ƴ�
		print(i_tag)
		# <i>example.com</i>							//�����Ѿ����Ƴ���i��ǩ,���Ѿ��Ƕ�����һ���ĵ�
		print(i_tag.parent)
		# None
		
		* �������ʵ���ϲ�����2���ĵ���:
			һ������������ԭʼ�ĵ��� BeautifulSoup ����,��
			һ���Ǳ��Ƴ����ҷ��ص�tag.���Ƴ������ص�tag���Լ������� extract ����


	* ʹ�� decompose() ��������ǰ�ڵ��Ƴ��ĵ�������ȫ����
		markup = '<a href="http://example.com/">I linked to <i>example.com</i></a>'
		soup = BeautifulSoup(markup)
		a_tag = soup.a
		# �Ƴ� i ��ǩ
		soup.i.decompose()
		print(a_tag)
		# <a href="http://example.com/">I linked to</a>		//i��ǩ�Ѿ����Ƴ�
	
	* ʹ�� replace_with()�����Ƴ��ĵ����е�ĳ������,������tag���ı��ڵ������
		markup = '<a href="http://example.com/">I linked to <i>example.com</i></a>'
		soup = BeautifulSoup(markup)
		a_tag = soup.a
		
		# �����µ�b��ǩ
		new_tag = soup.new_tag("b")
		# ����b��ǩ�ı�ǩ��
		new_tag.string = "example.net"
		# �Ƴ�i��ǩ,����ʹ��b��ǩ��������
		a_tag.i.replace_with(new_tag)
		print(a_tag)
		# <a href="http://example.com/">I linked to <b>example.net</b></a>
		
		* replace_with() �������ر������tag���ı��ڵ�,���������������ӵ��ĵ��������ط�
	
	* ʹ�� wrap() �������Զ�ָ����tagԪ�ؽ��а�װ ,�����ذ�װ��Ľ��
		soup = BeautifulSoup("<p>I wish I was bold.</p>")
		# ͨ��һ���½���b��ǩ,����װp�ڵ�ı�ǩ��(�ı��ڵ�)
		soup.p.string.wrap(soup.new_tag("b"))
		# <b>I wish I was bold.</b>
		
		# ͨ���½�һ�� div �ڵ�����װ p �ڵ�
		soup.p.wrap(soup.new_tag("div"))
		# <div><p><b>I wish I was bold.</b></p></div>
		
		* �÷����� Beautiful Soup 4.0.5 �����
	
	* ʹ�� unwrap()�Ƴ�tag�ڵ�����tag��ǩ,�÷��������������б�ǵĽ��
		markup = '<a href="http://example.com/">I linked to <i>example.com</i></a>'
		soup = BeautifulSoup(markup)
		a_tag = soup.a
		# �Ƴ�a��ǩ�е�i��ǩ
		a_tag.i.unwrap()
		print(a_tag)
		# <a href="http://example.com/">I linked to example.com</a>

		* �� replace_with() ������ͬ, unwrap() �������ر��Ƴ���tag