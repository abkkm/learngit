----------------------------
ԭ��ģʽ					|
----------------------------
	* prototype
	* ��ʵ���ǰ�һ��������и���,���Ƴ����Ķ���,��ӵ����ԭ������������Ժͷ���,���ҿ��Ի��ڸö��������ǿ,�޸�.���Ҳ���Ӱ��ԭ����

	
	* java ʵ�� Cloneable �ӿ�

	* ԭ���าд Object �� clone ����
		* ʵ�ֵĹ���ֻ��Ҫ���� return super.clone();

	* ͨ������ԭ��ʵ���� clone() ��������ȡ��һ��clone�Ķ���
		* clone��ȡ��ʵ��Ϊǳclone
		* ���Ҫ�� clone,��Ҫ�Լ�ȥʵ�� clone ���������

	

	* ����ͨ���������л�(io),�������clone
		
		//ԭʼ����
		Object obj = new Object();

		//�����ڴ��ֽ���
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		//��������д��,д���ڴ��ֽ�����
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		//д�����
		oos.writeObject(obj);
		
		//��д��Ķ����ȡΪ�ֽ�
		byte[] bytes = bos.toByteArray();
	
		//�����ֽڴ����ڴ��ֽڶ�ȡ��
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

		//���������ȡ��,���ڴ��ֽ��ж�ȡ
		ObjectInputStream ois = new ObjectInputStream(bis);
	
		//�Ӷ������ж�ȡ���¡����
		Object cloneObject = ios.readObject();


