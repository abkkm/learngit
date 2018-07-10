------------------------
�������ģʽ			|
------------------------
	# ������
	# �̰߳�ȫ
	# ���ø�Ч

------------------------
�������ֵ������ģʽ	|
------------------------
	# ����ʽ
		* �̰߳�ȫ,����Ч�ʸ�,�����ӳټ���
	# ����ʽ
		* �̰߳�ȫ,����Ч�ʲ���,�����ӳټ���
	# ˫�ؼ���ʽ
	# ��̬�ڲ�ʽ
	# ö�ٵ���

------------------------
�������ֵ������ģʽ-����|
------------------------
/**
 * ����ʽ
 * ���ø�Ч,������������,�̰߳�ȫ
 */
public class Single1 {
	
	public static final Single1 SINGLE = new Single1();
	
	private Single1() {}
	
	public static Single1 getInstance() {
		return SINGLE;
	}
}

/**
 * ����ʽ
 * �����ص��ǵ��ò���Ч,�̰߳�ȫ 
 */
public class Single2 {
	private static Single2 SINGLE_INSTANCE = null;
	private Single2() {}
	/**
	 * ����ʽ,�ӳټ���
	 * ͨ��˫��,����ֹ��������µİ�ȫ����
	 * ���ǵ�һ�ζ���,�����������
	 */
	public static Single2 getInstance() {
		if(SINGLE_INSTANCE == null) {
			Single2 singleDelay;
			synchronized (Single2.class) {
				singleDelay = SINGLE_INSTANCE;
				if(singleDelay == null) {
					synchronized (Single2.class) {
						singleDelay = new Single2();
					}
				}
				SINGLE_INSTANCE = singleDelay;
			}
		}
		return SINGLE_INSTANCE;
	}
}
/**
 * ͨ���ڲ���̬��,���ӳټ���,�����̰߳�ȫ
 * �̰߳�ȫ,����Ч�ʸ�,������
 */
public class Single3 {
	/**
	 * �౻���ص�ʱ��,ֻ���ʼ����̬����,�����ʼ����̬��
	 */
	public static class Single3ClassInstnce {
		private static final Single3 SINGLE = new Single3();  
	}
	private Single3() {}
	/**
	 * ֻ�е��� getInstance() ����ʱ,�Ż�����ڲ���̬��(Single3ClassInstnce)
	 * ��ļ������̰߳�ȫ��
	 * static final ���Ǳ�֤��ʵ����Ψһ��
	 */
	public static Single3 getInstance() {
		return Single3ClassInstnce.SINGLE;
	}
}
/**
 * ͨ��ö��������ʵ������,��������
 * �ǻ���JVM�ײ�ʵ�ֵ�,����ͷ����л��������ƽ�
 */
public enum Single4 {
	INSTANCE;
}


------------------------
������©��				|
------------------------
	# ��������ƽⵥ��,����ͨ������������,�������ʵ��
		* �����ڹ��������׳��쳣,����ֹ�������Ĵ���
	
	# �����л������ƽⵥ��
		* ͨ�����ӳ������ƽ�÷���
			/**
			 * java�����л��Ĺ��ӷ���
			 * �����л���ʱ��,��������˸÷���,�򷵻ظ÷����ķ��ض���
			 * @return
			 * @throws ObjectStreamException
			 */
			private Object readResolve() throws ObjectStreamException{
				return SINGLE;
			}

	# ö���Ǿ��԰�ȫ��