-----------------------
Linux-NginxԴ�밲װ		|
-----------------------
	1,��������Դ���,�ϴ���������
		nginx-1.10.1.tar.gz
	2,��ѹԴ���
		tar zxvf nginx-1.10.1.tar.gz
	3,����Դ���Ŀ¼
		* ָ����װĿ¼,��鰲װ
			./configure --prefix=/usr/local/nginx 
	4,ȷ�������ֱ�Ӱ�װ
		make && make install
	
	5,��װ�ɹ���,�����ĸ�Ŀ¼
		conf
			> �����ļ�
		html
			> web�����Ŀ¼,��ҳ�ļ�
		logs
			> ��־
		sbin
			> �����ű�
		* ����ʱ��������һЩ��׺��Ϊ:_temp����ʱĿ¼

	# ��װ����
		 the HTTP rewrite module requires the PCRE library
			* ȱ��������[PCRE]�Ŀ�
			* �������,ֱ�Ӱ�װ����������
					yum -y install pcre
					yum -y install pcre-devel
		
		 the HTTP gzip module requires the zlib library.
			* ȱ��:zlib����
			* �������,ֱ�Ӱ�װ������
					yum -y install zlib
					yum -y install zlib-devel


	# rpm��װ��ʽ�ҾͲ�˵��,�Ƕ�����.����.������service ����������ά��