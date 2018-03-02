package com.proxy;

public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloServiceProxy proxy = new HelloServiceProxy();  
        HelloService service = new HelloServiceImpl();  
        //绑定代理对象。  
        service = (HelloService) proxy.bind(service, new Class[] {HelloService.class});  
        //这里service经过绑定，就会进入invoke方法里面了。  
        service.sayHello("upc");  
	}

}
