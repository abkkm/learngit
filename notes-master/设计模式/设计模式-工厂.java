---------------------
����ģʽ			 |
---------------------
	# ʵ���˴����ߺ͵����ߵķ���
	# ����
		�򵥹���
		��������
		���󹤳�

---------------------
����ģʽ-��		 |
---------------------
	/**
	 * ����ӿ�
	 */
	public interface Car {
		void run();
	}
	/**
	 * ����ʵ��
	 */
	public class Audi implements Car{
		public void run() {
			System.out.println("audi is run");
		}
	}
	/**
	 * ����ʵ��
	 */
	public class Baoma implements Car{

		public void run() {
			System.out.println("baoma run");
		}
	}
	/**
	 * ���幤��
	 */
	public class Factory1 {
		public static Car getCar(String name) {
			if(name.equals("audi")) {
				return new Audi();
			}else {
				return new Baoma();
			}
		}
	}
	* ̫�򵥵Ķ���,û���Ҫ��ʾ
	* Ҳ��Ϊ��Ϊ��̬����

---------------------
����ģʽ-��������	 |
---------------------
	* ����Ҳ����ӿ�,��ͬ�Ĺ���������ͬ�ӿڵ�ʵ��
	


---------------------
����ģʽ-���󹤳�	 |
---------------------
	* �����е����������,������