--------------------------------
�Ž�ģʽ						|
--------------------------------
	* ��γ�ȵĹ�ϵ,�е���ѿ���������˼
		Ʒ��	����

		����	̨ʽ��
		����	�ʼǱ�
		ƻ��	ƽ��
	
	* ��չƷ�ƻ�����չ����,�����д������,һ��ʵ��Ʒ��,һ��ʵ������

	* ʹ�����Ա�ķ�ʽ����̳й�ϵ
	


/**
 * Ʒ��
 */
public interface Brand {
	void sale();
}

class Lenovo implements Brand{
	public void sale() {
		System.out.println("�����������");
	}
}

class Dell implements Brand{
	public void sale() {
		System.out.println("���۴�������");
	}
}

/**
 * ����
 */
public abstract class Computer {
	protected Brand brand;
	public Computer(Brand brand) {
		this.brand = brand;
	}
	
	public void sale() {
		this.brand.sale();
	}
}

//����̨ʽ��
class Desktop extends Computer{
	public Desktop(Brand brand) {
		super(brand);
	}
	@Override
	public void sale() {
		super.sale();
		System.out.println("����̨ʽ��");
	}
}
//����ʼǱ�
class Laptop extends Computer{

	public Laptop(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println("���۱ʼǱ�");
	}
}

public static void main(String[] args) {
	Computer desktop = new Desktop(new Lenovo());
	desktop.sale();
}