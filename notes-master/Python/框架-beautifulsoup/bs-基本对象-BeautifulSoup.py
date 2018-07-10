----------------------------
BeautifulSoup				|
----------------------------
	* BeautifulSoup �����ʾ����һ���ĵ���ȫ������
	* �󲿷�ʱ��,���԰������� Tag ����,��֧�� �����ĵ��� �� �����ĵ��� �������Ĵ󲿷ֵķ���
	* BeautifulSoup ���󲢲���������HTML��XML��tag,������û��name(����һ����ʵ)��attribute����.

----------------------------
BeautifulSoup-����			|
----------------------------
	name 
		* ������ֵ�ǹ̶���:"[document]"

----------------------------
BeautifulSoup-ע�͵�����Ԫ��|
----------------------------
	* ע�������� Comment,��һ������� NavigableString 
		markup = "<b><!--Hey, buddy. Want to buy a used parser?--></b>"
		soup = BeautifulSoup(markup,'html.parser')

		comment = soup.b.string
		print(type(comment))
		# <class 'bs4.element.Comment'>
	
	* ��������HTML�ĵ���ʱ, Comment �����ʹ������ĸ�ʽ���:
		print(soup.b.prettify())
		# <b>
		#  <!--Hey, buddy. Want to buy a used parser?-->
		# </b>
	
	* Beautiful Soup�ж�����������Ͷ����ܻ������XML���ĵ���:
			CData 
			ProcessingInstruction 
			Declaratio
			Doctype 
			* �� Comment ��������,��Щ�඼�� NavigableString ������
			* ֻ�������һЩ����ķ���
	
	* xml�е�cdata
		from bs4 import CData
		# ����cdata����
		cdata = CData("A CDATA block")
		# �滻ԭ����ע�Ͷ���
		comment.replace_with(cdata)	# replace_with �Ǹ���:NavigableString �ķ���
		print(soup.b.prettify())
		# <b>
		#  <![CDATA[A CDATA block]]>
		# </b>

