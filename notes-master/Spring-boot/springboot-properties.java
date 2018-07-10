-------------------------------
Spring boot-������				|
-------------------------------
	// Server���
		server.port=80
			# WEB�����˿�

		server.context-path=/
			# WEB����·��
	
	//���봦��
		server.tomcat.uri-encoding=UTF-8
		spring.http.encoding.charset=UTF-8
		spring.http.encoding.enabled=true

	//���ڸ�ʽ����
		spring.mvc.date-format=yyyy-MM-dd HH:mm:ss

	//��־
		logging.config=classpath:community-logback.xml
			# logback�����ļ���ַ
	
	//��̬�ļ�ӳ��
		spring.mvc.static-path-pattern=/static/**													*/
			# ���þ�̬��Դ�ķ���ǰ׺,Ĭ�������,��̬��ԴĿ¼��
				* /static 
				* /public
				* /resources
				* /META-INF/resources

			# ����ָ����̬�ļ���Ŀ¼(��classpathĿ¼��-src/main/resources),�������ֱ�ӷ���
		
		spring.resources.static-locations[0]=
			# Ҳ�Ǿ�̬��Դ��ӳ�䴦��,��һ������,֧�ֶ��
			# ֧�� classpath:/ ,֧�� file:/

	//MyBatis
		mybatis.mapper-locations[0]=classpath*:mapper/**/Mapper.xml
			# mybatis mapper�ļ�ɨ���ַ

		mybatis.config-location=classpath:mybatis/mybatis-config.xml
			# mybatis�����ļ���ַ

	//�����ⲿ�����ļ�
		spring.profiles.include[0]=datasource
		spring.profiles.include[1]=redis
	
	//�ϴ�����
		spring.servlet.multipart.max-file-size=30MB
		spring.servlet.multipart.max-request-size=30MB
		spring.servlet.multipart.enabled=true