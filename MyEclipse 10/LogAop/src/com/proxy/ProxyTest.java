package com.proxy;

public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloServiceProxy proxy = new HelloServiceProxy();  
        HelloService service = new HelloServiceImpl();  
        //�󶨴������  
        service = (HelloService) proxy.bind(service, new Class[] {HelloService.class});  
        //����service�����󶨣��ͻ����invoke���������ˡ�  
        service.sayHello("upc");  
	}

}
