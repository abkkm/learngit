----------------------------
java-nio					|
----------------------------
	* �ο�����
		http://ifeve.com/overview/




----------------------------
�ؼ����					|
----------------------------
	ServerSocketChannel	
		* ServerSocket ������,֧������ͨ���������ͨ��

	SocketChannel
		* Socket ������,֧������ͨ���������ͨ��

	Selector
		* Ϊ ServerSocketChannel	��ؽ������Ӿ����¼�
		* Ϊ SocketChannel			������Ӿ���,������,д�����¼�

	SelectionKey
		* ���� ServerSocketChannel �� SocketChannel �� Selector ע���¼��ľ��
		* ��һ�� SelectionKey ����λ�� Selector ����� selected-keys ������ʱ,�ͱ�ʾ����� SelectionKey ������ص��¼�������

	
----------------------------
Channel ��ϵͼ				|
----------------------------
				|----------Channel-------------|
		SelectableChannel				(interface)ByteChannel
		|				|----------------------|
ServerSocketChannel	SocketChannel


----------------------------
SelectionKey �¼�����		|
----------------------------
	SelectionKey.OP_ACCEPT;
		* ������Ӿ���,��ʾ������һ���ͻ�������,���������Խ����������

	SelectionKey.OP_CONNECT;
		* ���Ӿ����¼�,��ʾ�ͻ���������������Ѿ������ɹ���

	SelectionKey.OP_READ;
		* �������¼�,��ʾ���������Ѿ��пɶ�����,����ִ�ж�������

	SelectionKey.OP_WRITE;
		* д�����¼�,��ʾ�Ѿ������������д������
	
