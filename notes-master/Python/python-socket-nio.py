--------------------------------
NIO-����IOģʽ					|
--------------------------------
	ͬ�� ����		
	ͬ�� ������

	�첽 ����
	�첽 ������

	select	->	poll	->	epoll


--------------------------------
NIO-select-ģ�麯��				|
--------------------------------
	select(input,output,error,time)
		* ����selectʵ������
		* ����
			input	:
			output	:
			error	:
			time	:������ʱ����ѯһ��

--------------------------------
NIO-select-epoll				|
--------------------------------
import socket
import select

# �����׽���
server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
# ���ÿ����ظ�ʹ�ð󶨵���Ϣ
server.setsockopt(socket.SOL_SOCKET,socket.SO_REUSEADDR,1)
# �󶨱�����Ϣ
server.bind(("0.0.0.0",7788))
# ��Ϊ����
server.listen(10)
# ����һ��epoll����
epoll = select.epoll()

# ע���¼���epoll��
# epoll.register(fd[, eventmask])
# ע�⣬���fd�Ѿ�ע�������ᷢ���쳣
# ���������׽�����ӵ�epoll���¼�������
epoll.register(server.fileno(),select.EPOLLIN|select.EPOLLET)

connections = {}
addresses = {}

# ѭ���ȴ��ͻ��˵ĵ������߶Է���������
while True:
    # epoll ���� fd ɨ��ĵط� -- δָ����ʱʱ����Ϊ�����ȴ�
    epoll_list = epoll.poll()
    # ���¼������ж�
    for fd,events in epoll_list:
        # �����socket�������׽��ֱ�����
        if fd == server.fileno():
            conn,addr = server.accept()
            print('���µĿͻ�������%s'%str(addr))
            # �� conn �� addr ��Ϣ�ֱ𱣴�����
            connections[conn.fileno()] = conn
            addresses[conn.fileno()] = addr
            # �� epoll ��ע�� ���� socket �� �ɶ� �¼�
            epoll.register(conn.fileno(), select.EPOLLIN | select.EPOLLET)
        elif events == select.EPOLLIN:
            # �Ӽ��� fd �Ͻ���
            recvData = connections[fd].recv(1024)
            if len(recvData) > 0:
                print('recv:%s'%recvData)
            else:
                # �� epoll ���Ƴ��� ���� fd
                epoll.unregister(fd)
                # server �������رո� ���� fd
                connections[fd].close()
                print("%s---offline---"%str(addresses[fd]))
	




	