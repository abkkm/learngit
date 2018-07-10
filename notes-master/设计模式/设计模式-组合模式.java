----------------------------
���ģʽ					|
----------------------------
	* �ڴ������νṹ��ʱ��,�Ϳ���ʹ�����ģʽ
	* ���ģʽ�ĺ���
		* ���󹹼�(Component),����Ҷ�ӽڵ�������ڵ�Ĺ�ͬ��
		* Ҷ��(Leaf),���ӽڵ�
		* ����(Composite),�������ӽڵ�

----------------------------
demo						|
----------------------------
import java.util.ArrayList;
import java.util.List;

//�������
public interface Component {
	//Ҷ��,�����ڵ㶼�߱��ķ���
	void operation();
}

//Ҷ�����
interface Leaf extends Component{
	
}


//ͼƬ�ļ�
class ImgFile implements Leaf{
	public void operation() {
		System.out.println("ͼƬ�ļ�");
	}
}
//�ı��ļ�
class TextFile implements Leaf{
	//Ҷ�Ӳ�����ʵ��
	public void operation() {
		System.out.println("�ı��ļ�");
	}
}

//�ļ���
class Folder implements Component{
	
	private List<Component> subFiles = new ArrayList<>();
	
	//���Ҷ��
	public void add(Component component) {
		this.subFiles.add(component);
	}
	
	//ɾ��Ҷ��
	public void remove(Component component) {
		this.subFiles.remove(component);
	}

	/**
	 * 
	 * ����������ʵ��,���Ǳ���Ҷ��,Ȼ�����Ҷ�ӵĲ���
	 * ���Ҷ��Ҳ��һ������,����һ����Ȼ�ĵݹ���
	 * 
	 */
	@Override
	public void operation() {
		for (Component component : subFiles) {
			component.operation();
		}
	}
}