----------------------------
MySQL-5.7.x ��װ			|
----------------------------
	1,��װ���뻷��
		yum -y install cmake ncurses ncurses-devel bison bison-devel boost boost-devel
		yum install -y gcc
		yum install -y gcc-c++

	2,Դ�����ص�ַ
		http://ftp.ntu.edu.tw/MySQL/Downloads/MySQL-5.7/
		http://ftp.ntu.edu.tw/MySQL/Downloads/MySQL-5.7/mysql-5.7.17.tar.gz
	
	3,�����ѹĿ¼��,ִ�б�������
		* ���boost���ع���������
		* ����������(tar.gz��)��ָ����Ŀ¼(-DWITH_BOOST����Ŀ¼)
			http://www.boost.org/
			https://nchc.dl.sourceforge.net/project/boost/boost/1.59.0/boost_1_59_0.tar.gz
			http://sourceforge.net/projects/boost/files/boost/1.59.0/boost_1_59_0.tar.gz
				
		cmake \
			-DCMAKE_INSTALL_PREFIX=/usr/local/mysql  \              [MySQL��װ�ĸ�Ŀ¼]
			-DMYSQL_DATADIR=/usr/local/mysql/data  \                   [MySQL���ݿ��ļ����Ŀ¼]
			-DSYSCONFDIR=/etc \                                     [MySQL�����ļ�����Ŀ¼]
			-DMYSQL_USER=mysql \                                    [MySQL�û���]   
			
			-DWITH_MYISAM_STORAGE_ENGINE=1 \                        
			-DWITH_INNOBASE_STORAGE_ENGINE=1 \                      
			-DWITH_ARCHIVE_STORAGE_ENGINE=1 \                       
			-DWITH_FEDERATED_STORAGE_ENGINE=1 \						[MySQL�����ݿ�����]
			-DWITH_BLACKHOLE_STORAGE_ENGINE=1 \
			-DWITH_MEMORY_STORAGE_ENGINE=1 \                        
			-DWITH_PARTITION_STORAGE_ENGINE=1  \				
			
			-DWITH_READLINE=1 \                                     [MySQL��readline library]
			-DMYSQL_UNIX_ADDR=/run/mysql/mysql.sock \				[MySQL��ͨѶĿ¼]
			-DMYSQL_TCP_PORT=1124 \                                 [MySQL�ļ����˿�]
			-DENABLED_LOCAL_INFILE=1 \                              [���ü��ر�������]
			-DENABLE_DOWNLOADS=1 \                                  [����ʱ����������������ļ�]
			-DEXTRA_CHARSETS=all \                                  [ʹMySQL֧�����е���չ�ַ�]
			-DDEFAULT_CHARSET=utf8mb4 \                             [����Ĭ���ַ���Ϊutf8]
			-DDEFAULT_COLLATION=utf8mb4_general_ci \                [����Ĭ���ַ�У��]
			-DWITH_DEBUG=0 \                                        [���õ���ģʽ]
			-DMYSQL_MAINTAINER_MODE=0 \
			-DWITH_SSL:STRING=bundled \                             [ͨѶʱ֧��sslЭ��]
			-DWITH_ZLIB:STRING=bundled \                            [����ʹ��zlib library]
			-DDOWNLOAD_BOOST=1 \
			-DWITH_BOOST=/usr/local/mysql/boost_1_59_0				[boost�ⰲװĿ¼]
		
cmake \
-DCMAKE_INSTALL_PREFIX=/usr/local/mysql \
-DMYSQL_DATADIR=/usr/local/mysql/data \
-DSYSCONFDIR=/etc \
-DMYSQL_USER=mysql \
-DWITH_MYISAM_STORAGE_ENGINE=1 \
-DWITH_INNOBASE_STORAGE_ENGINE=1 \
-DWITH_ARCHIVE_STORAGE_ENGINE=1 \
-DWITH_FEDERATED_STORAGE_ENGINE=1 \
-DWITH_BLACKHOLE_STORAGE_ENGINE=1 \
-DWITH_MEMORY_STORAGE_ENGINE=1 \
-DWITH_PARTITION_STORAGE_ENGINE=1 \
-DWITH_READLINE=1 \
-DMYSQL_UNIX_ADDR=/run/mysql/mysql.sock \
-DMYSQL_TCP_PORT=1124 \
-DENABLED_LOCAL_INFILE=1 \
-DENABLE_DOWNLOADS=1 \
-DEXTRA_CHARSETS=all \
-DDEFAULT_CHARSET=utf8mb4 \
-DDEFAULT_COLLATION=utf8mb4_general_ci \
-DWITH_DEBUG=0 \
-DMYSQL_MAINTAINER_MODE=0 \
-DWITH_SSL:STRING=bundled \
-DWITH_ZLIB:STRING=bundled \
-DDOWNLOAD_BOOST=1 \
-DWITH_BOOST=/usr/local/mysql/boost_1_59_0

	4,����OK��,ִ�б��밲װ	
		make && make install
	
		* ����������ڴ治�������
			dd if=/dev/zero of=/swapfile bs=64M count=16
				//dd if=/dev/zero of=/swapfile bs=1k count=2048000
			mkswap /swapfile
			swapon /swapfile

			�������֮��
			
			swapoff /swapfile
			rm /swapfile -f
	
	5,��MySQL���ݿ�Ķ�̬���ӿ⹲����ϵͳ���ӿ�
		* ����MySQL����Ϳ��Ա��������������
		ln -s /usr/local/mysql/lib/libmysqlclient.so.20 /usr/lib/libmysqlclient.so.20 
	
	6,��ӻ�������
		PATH=/usr/local/mysql/bin:/usr/local/mysql/lib:$PATH
		export PATH
		
		source /etc/profile

	7,���������ű�
		cp /usr/local/mysql/support-files/mysql.server /etc/init.d/mysql
	
	8,�༭�����ļ�
		* �ȸ��Ƶ�Ŀ¼
			cp /usr/local/mysql/support-files/my-default.cnf /etc/my.cnf

		* �༭
			basedir = /usr/local/mysql
			datadir = /usr/local/mysql/data
			port = 1124
			server_id = 1
			socket = /run/mysql/mysql.sock 

	9,ִ����Ȩ����
		chown mysql /usr/local/mysql -R
		chmod 775 /usr/local/mysql -R

		mkdir /var/run/mysql
		chown mysql /var/run/mysql -R
		chmod 775 /var/run/mysql -R
	
	10,ִ�����ݿ��ʼ��/���ÿ�������
		mysqld --initialize-insecure --user=mysql --basedir=/usr/local/mysql --datadir=/usr/local/mysql/data 
		chkconfig mysql on
	
	11,����mysql
		service mysql start
		* �������ʧ��,�ȼ���Ƿ�mariadb�Ѿ�ɾ��
			rpm -qa | grep mariadb 
			yum -y remove mariadb-libs-5.5.52-1.el7.x86_64
	
	12,ִ�е�¼/�޸�����
		mysql -uroot
		ALTER USER 'root'@'localhost' IDENTIFIED BY 'new_password';

	13,�޸�����/��¼Ȩ��
		GRANT ALL PRIVILEGES ON *.* TO root@'%' IDENTIFIED BY 'new_password';
		FLUSH PRIVILEGES;
	
	14,�������ʶ˿�
		firewall-cmd --add-port=1124/tcp --permanent 
		firewall-cmd --reload  



c++: internal compiler error: Killed (program cc1plus)
Please submit a full bug report,
with preprocessed source if appropriate.
See <http://bugzilla.redhat.com/bugzilla> for instructions.
make[2]: *** [unittest/gunit/CMakeFiles/merge_small_tests-t.dir/merge_small_tests.cc.o] Error 4
make[1]: *** [unittest/gunit/CMakeFiles/merge_small_tests-t.dir/all] Error 2
make: *** [all] Error 2

------------------------ yum��װ	
http://blog.csdn.net/xyang81/article/details/51759200

1,����
	https://dev.mysql.com/downloads/repo/yum/
	Red Hat Enterprise Linux 7 / Oracle Linux 7 (Architecture Independent), RPM Package		25.1K	
	(mysql57-community-release-el7-11.noarch.rpm)

	* mysql 8
		https://repo.mysql.com//mysql80-community-release-el7-1.noarch.rpm

2,��װyumԴ
	yum localinstall mysql57-community-release-el7-11.noarch.rpm

	* �鿴yumԴ�Ƿ�װ�ɹ�/etc/yum.repos.d/mysql-community.repo
		yum repolist enabled | grep "mysql.*-community.*"

		mysql-connectors-community/x86_64    MySQL Connectors Community               45
		mysql-tools-community/x86_64         MySQL Tools Community                    59
		mysql57-community/x86_64             MySQL 5.7 Community Server              247

	* �޸�Ĭ�ϰ�װ��mysql�汾
		vim /etc/yum.repos.d/mysql-community.repo

		# Enable to use MySQL 5.5
		[mysql55-community]
		enabled=0					# ����װ5.5

		# Enable to use MySQL 5.6
		[mysql56-community]
		enabled=0					# ����װ5.6

		# Enable to use MySQL 5.7
		[mysql57-community]
		enabled=1					# ��װ5.7
		
		enabled=1		//��ʾ��װ
		enabled=0		//��ʾ����װ

3,��װmysql������
	yum install mysql-community-server

4,����mysql����
	systemctl start mysqld
	
	* �鿴mysql����״̬
		systemctl status mysqld
	
	* ���ÿ�������
		systemctl enable mysqld
		systemctl daemon-reload


5,�޸�root���ص�¼����
	* �鿴��ʱ����
		less /var/log/mysqld.log | grep 'temporary password'
	
	* ʹ����ʱ������е�¼
		mysql -uroot -p
	
	* ִ���޸����뷽ʽ1
		ALTER USER 'root'@'localhost' IDENTIFIED BY 'new pass'; 
	
	* ִ���޸����뷽ʽ2
		set password for 'root'@'localhost' = password('new pass'); 
	
	* ע��
		mysql5.7Ĭ�ϰ�װ�����밲ȫ�����(validate_password),Ĭ�����������Ҫ������������:��Сд��ĸ,���ֺ��������,���ҳ��Ȳ�������8λ
		�������ʾERROR 1819 (HY000):Your password does not satisfy the current policy requirements

6,��Ȩ�û���Զ�̵�¼
	GRANT ALL PRIVILEGES ON *.* TO 'KevinBlandy'@'%' IDENTIFIED BY 'pass' WITH GRANT OPTION; 
	
		*.*			�������ݿ��µ��������ݱ�
		KevinBlandy �û���
		%			����ip
		pass		����
	
	flush privileges;
	
	# mysql 8����Ҫͨ��ROLE������������Ȩ
		1,����1�����߶����ɫ
			CREATE ROLE 'app_developer', 'app_read', 'app_write';
		
		2,�Դ����Ľ�ɫ������Ȩ
			* �﷨ 
				GRANT [Ȩ��] ON [db].[tb] TO [��ɫ]
			
			* Ȩ����ö��,�����ж��,����ֱ���� ALL ����,��ʾ����Ȩ��
				SELECT,INSERT, UPDATE, DELETE
			
			* demo
				GRANT ALL		ON app_db.* TO 'app_developer';
				GRANT SELECT	ON app_db.* TO 'app_read';
				GRANT INSERT, UPDATE, DELETE ON app_db.* TO 'app_write';
		
		3,�����û�
			CREATE USER 'KevinBlandy'@'%' IDENTIFIED BY '123456';
		
		4,��Ȩ��ɫ���û�
			* �﷨
				GRANT [��ɫ] TO [�û���]@[ip]
			
			* demo
				GRANT 'app_developer' TO 'dev1'@'localhost';
					* ��Ȩ�û���ָ����ip����ʹ��һ����ɫ
				GRANT 'app_read' TO 'read_user1'@'localhost', 'read_user2'@'localhost';
					* ��Ȩ�û��ڲ�ͬ��IP����ʹ�ò�ͬ�Ľ�ɫ
				GRANT 'app_read', 'app_write' TO 'rw_user1'@'localhost';
					* ��Ȩ�û���һ��ip����ʹ�ö����ɫ

		# ͨ��
			 CREATE ROLE 'app_developer';
			 GRANT ALL ON *.* TO 'app_developer';
			 CREATE USER 'KevinBlandy'@'%' IDENTIFIED BY '123456';
			 GRANT 'app_developer' TO 'KevinBlandy'@'%';



7,����Ĭ�ϱ���
	* �༭:vim /etc/my.cnf,�� [mysqld] ���������������
		character_set_server=utf8
		init_connect='SET NAMES utf8'
	
	* ����mysql����
		systemctl restart mysqld

	* ��¼,�鿴����
		show variables like '%character%';


8,Ĭ�������ļ�·��
	�����ļ�:	/etc/my.cnf 
	��־�ļ�:	/var/log//var/log/mysqld.log 
	���������ű�:	/usr/lib/systemd/system/mysqld.service 
	socket�ļ�:		/var/run/mysqld/mysqld.pid

9,ά������
	* ��������
		systemctl start mysqld

	* ֹͣ����
		systemctl stop mysqld

	* ��������
		systemctl restart mysqld
	
	* �鿴mysql����״̬
		systemctl status mysqld
	
	* ���ÿ�������
		systemctl enable mysqld
		systemctl daemon-reload