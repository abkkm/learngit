----------------------------
subprocess					|
----------------------------
	* �����ӽ���,����ִ��ϵͳ����
	* �����ӽ��̹���

----------------------------
subprocess-����				|
----------------------------
	PIPE

----------------------------
subprocess-����				|
----------------------------
	Popen()
		* ����һ���ӽ���,ִ��һ��shell����,����һ�� Popen ����
		* ��������������,��һ��Ԫ��������,ʣ�µ������������
			Popen(["mkdir","t1"])
		* ����Ҳ����ֱ�Ӿ���һ������
			Popen("mkdir t2", shell=True)
		* �ؼ��ֲ���
			shell
				* bool ֵ
			stdout	
				* ö��ֵ,ָ������ִ�к�������ݵĹܵ�
				* subprocess.PIPE		:���ӽ���ת��������

	str getoutput(commond)
		* ִ��SHELL����,����ִ�к�Ľ��

	tuple getstatusoutput(commond)
		* ִ��shell����,����Ԫ��,��һ��������״̬intֵ,�ڶ���������ִ�к�Ľ��
	
	check_output()
		* �����̵ȴ��ӽ������
		* ���ִ���쳣���׳�:subprocess.CalledProcessError
		* �����ӽ������׼�����������
		* �ؼ��ֲ���
			stderr
			shell
		* demo
			subprocess.check_output('dir',stderr=subprocess.STDOUT,shell=True)

----------------------------
subprocess.Popen			|
----------------------------
	* ʵ������
		stdout.read()
			* ��ȡִ�н��,���صĽ�����ֽ���������
			* ���������ַ���,��ʾ��������,����Ĭ��ʹ��ϵͳ����
	* demo
		import subprocess
		popen = subprocess.Popen('dir',shell=True,stdout=subprocess.PIPE,stderr=subprocess.PIPE)
		# stdout=subprocess.PIPE ����ӽ���ִ�еĽ������,���ݸ�������.���ո�ֵ��ִ�к�Ķ���.���û�иò���,��ֱ�Ӵ�ӡ,�����ض����ܶ�ȡ��ִ�н��
		result = popen.stdout.read()	# ��ȡ���
		error  = popen.stderr.read()	# ��ȡ�쳣���,���û���쳣,��ֵΪNone
		print(str(result,'GBK'))