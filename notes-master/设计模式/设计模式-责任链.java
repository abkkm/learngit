----------------------------
���������ģʽ				|
----------------------------
	* �������, HttpServetFilter

----------------------------
demo						|
----------------------------
//�������������
public abstract class Interceptor {
	//��һ��������
	protected Interceptor next;
	public Interceptor() {}
	public Interceptor(String name, Interceptor next) {
		super();
		this.next = next;
	}
	public Interceptor getNext() {
		return next;
	}
	public void setNext(Interceptor next) {
		this.next = next;
	}
	//ִ�����صķ���
	public abstract void chain(HttpRequest request);
}

//����������������
public class ContentTypeInterceptor extends Interceptor{
	@Override
	public void chain(HttpRequest request) {
		if(request.getContentType().equals("application/json")) {
			//��json����һ�����������д���
			next.chain(request);
		}else {
			System.out.println("ContentType������json");
		}
	}
}

//ip����������
public class RemoteIpInterceptor extends Interceptor{
	@Override
	public void chain(HttpRequest request) {
		if(request.getRemoteIp().equals("0.0.0.0")) {
			//ip��0.0.0.0�ͽ�����һ������������
			getNext().chain(request);
		}else {
			System.out.println("ip����Ϊ 0.0.0.0");
		}
	}
}

//http request��װ
public class HttpRequest {
	private String contentType;
	private String remoteIp;
	public HttpRequest() {}
	public HttpRequest(String contentType, String remoteIp) {
		super();
		this.contentType = contentType;
		this.remoteIp = remoteIp;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
}

public static void main(String[] args) {
	//������һ��������
	ContentTypeInterceptor contentTypeInterceptor = new ContentTypeInterceptor();
	//�����ڶ���������
	contentTypeInterceptor.setNext(new RemoteIpInterceptor());
	contentTypeInterceptor.chain(new HttpRequest("application/json","120.0.0.1"));
}
