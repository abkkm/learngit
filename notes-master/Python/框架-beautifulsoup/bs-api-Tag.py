--------------------------------
beautifulsoup-Tag			 	|
--------------------------------
	* <class 'bs4.element.Tag'>


--------------------------------
beautifulsoup-����			 	|
--------------------------------
	name
		* ���ر�ǩ����

	attrs
		* ��������dict
	
	contents 
		* ����list,��ǰ��ǩ'����ֱ����Ԫ�ؼ���',�����ı��ڵ�(bs4.element.NavigableString)
		* '�ַ����ڵ�û�и�����'
	
	children 
		* ���ص�����,��ǰ��ǩ��'����ֱ����Ԫ��'
	
	descendants
		* ���ص�ǰ��ǩ��'������Ԫ��'
		* �ݹ�
	
	string
		* ��ȡ��ǰ��ǩ���ı���ǩ
	
	strings
		* ��ȡ��ǰ��ǩ�µ������ı���ǩ,�ݹ��ȡ
	
	stripped_strings 
		* ͬ��.�հ׻ᱻ���Ե�

--------------------------------
beautifulsoup-����			 	|
--------------------------------
	get(attr)
		* ��ȡָ�����Ƶ�����ֵ,���Բ����ڷ���None
	
	find_all(name , attrs , recursive , string , **kwargs )
		* ��ȡ�ӱ�ǩ��ָ�����Ƶı�ǩ����,����list
		* ���������Ǳ�ǩ����,Ҳ�ǿ�����һ�� �������(re),Ҳ������һ������������
		* ����
			name
				* �Բ�����������Ϊ name ��tag,�ַ�������ᱻ�Զ����Ե�.
			string 
				* ͨ�� string �������������ĵ��е��ַ�������,�� name �����Ŀ�ѡֵһ��
			keyword 
				* ͨ��ָ����������ֵ������
				* ֵҲ������[]��������
				* ��ֵΪ True,���ʾ����ֵ,���Դ��ھ�OK
			attrs
				* ����ֵ�� dict ��ʾ
		* ͨ��limit�ؼ��ֲ��������Ƽ����Ľ��������,��sql�е�limitһ��
		* ͨ��recursive�ؼ��ֲ����������Ƿ�Ҫ�ݹ����(�����༶�ӽڵ�),Ĭ��Ϊ True
	
	find()
		* �� find_all һ��,�����ص�ֻ��һ�����

	find_parents()
	find_parent() 
		* ���������ڵ�
	
	find_next_siblings()
	find_next_sibling()
		* �����ֵܽڵ�
	
	find_previous_siblings()
	find_previous_sibling()
		* ������/��һ�������ڵ�
	
	find_all_next()
	find_next()
		
	find_all_previous() 
	find_previous()
		
	
	clear()
		* �����ǰ��ǩ�е��ı��ڵ�(���Ǳ�ǩ��)
	
	extract()
		* �Ƴ���ǰ�ڵ�,���ҷ���
		* ���صĽڵ���һ��������html�ĵ�

	decompose()
		* �Ƴ���ǰ�ڵ�,���Ҵ��ڴ�������
	
	replace_with(new_tag)
		* ʹ�� new_tag �����浱ǰtag,���ص�ǰtag
	
	wrap(tag)
		* ʹ��tag����װ��ǰtag
		* �ϸ��װְ�
	
	prettify()
		* ����ڵ�
	
	get_text()
		* ��ȡ�ӽڵ������е��ı��ڵ���Ϣ
		* �������Դ���һ���ָ���,�÷ָ�����Խ�����зָ�
		* �ؼ��ֲ���
			strip
				* �����ֵΪ True,��ȥ������Ŀո�.Ĭ�� False

	


	



			
			
	

