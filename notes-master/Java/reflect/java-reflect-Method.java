
---------------------
java.reflect.Method	 |
---------------------

---------------------
ʵ������			 |
---------------------
	invoke(Object obj,Object value...);
		* �Է���ķ���ִ�з�������,��һ��������ʾ���ĸ�����Ĵ˷���,�ڶ���������ʾ��������,���û��ֱ�����Ӽ���

	<T extends Annotation>  getAnnotation(Class<T> annotationClass) 
		* ������ڸ�Ԫ�ص�ָ�����͵�ע�ͣ��򷵻���Щע�ͣ����򷵻� null�� 

	Annotation[] getDeclaredAnnotations();  
		* ��ȡ�÷������е�ע��

	boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);
		* �ж��Ƿ���ָ�����͵�ע���ʶ�ڸ÷���
	
	int getModifiers()
		* ����Ȩ�����εı�ʾ��ֵ(public,private,native,final....)
	
	 Class<?> getReturnType()
		* ���� return ��Class������
	

	
