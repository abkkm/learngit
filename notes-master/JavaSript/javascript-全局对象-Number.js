------------------------
Number					|
------------------------
	# �������͵İ�װֵ
		var x = 5;
		var y = new Number(5);
		x == y		//true
		x === y		//false

	# ����
		var num = new Number(value);
			* ���һ������ֵ����ת��Ϊһ�����ֽ����� NaN (������ֵ)��

	# ��̬����
		MAX_VALUE	
			* �ɱ�ʾ��������

		MIN_VALUE	
			* �ɱ�ʾ����С����

		NEGATIVE_INFINITY	
			* �������,���ʱ���ظ�ֵ

		POSITIVE_INFINITY	
			* ����������ʱ���ظ�ֵ

		NaN	
			* ������ֵ
		
		Number.EPSILON
			* ����ʾ 1 ����� 1 ����С������֮��Ĳ�
		
		
		Number.MAX_SAFE_INTEGER
			* JavaScript �ܹ�׼ȷ��ʾ���������

		Number.MIN_SAFE_INTEGER
			* JavaScript �ܹ�׼ȷ��ʾ����С����


	
	# ��̬����
		isFinite()
			* �ж������ǲ���һ��������������
			* !Infinity 
			* ����������Ͳ�����ֵ��Number.isFiniteһ�ɷ���false
		
		isNaN()
			* �ж������Ƿ���һ��������
			* NaN
		
		parseInt()
		parseFloat()
			* ��ָ������ת��ΪInt���͵�����
			* ��ʵ�����Ǹ�ȫ�ֺ���
				Number.parseInt === parseInt	 // true
				Number.parseFloat === parseFloat // true
		
		isInteger()
			* �ж�һ�����Ƿ�Ϊ����
			* '�����ݾ��ȵ�Ҫ��ϸ�,������ʹ��Number.isInteger()�ж�һ����ֵ�Ƿ�Ϊ����'
		
		isSafeInteger()
			* �Ƿ���һ����ȫ������,Ҳ����˵ֵ�Ƿ��� MAX_SAFE_INTEGER �� MIN_SAFE_INTEGER ֮��

	
	# ʵ������
		toExponential(x)	
			* �Ѷ����ֵת��Ϊָ����������
			* �������,4��5��,����,��0

		toFixed(x)
			* ������ת��Ϊ�ַ����������С�������ָ��λ�������֡�
			* �������,4��5��,����,��0

		toPrecision(x)
			* �����ָ�ʽ��Ϊָ���ĳ��ȡ�
			* �������,4��5��,����,��0

		toString()
			* ������ת��Ϊ�ַ�����ʹ��ָ���Ļ�����

		valueOf()
			* ����һ�� Number ����Ļ�������ֵ��
			* ���ص���10����