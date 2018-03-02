package com.proxy;

import java.lang.reflect.InvocationHandler;  
import java.lang.reflect.Method;  
import java.lang.reflect.Proxy;  

public class HelloServiceProxy implements InvocationHandler {  


    private Object target;    
    /**  
     * ��ί�ж��󲢷���һ��������ռλ�� 
     * @param target ��ʵ���� 
     * @return  �������ռλ�� 
     */    
    public  Object bind(Object target, Class[] interfaces) {    
        this.target = target;    
        //ȡ�ô������    
       return Proxy.newProxyInstance(target.getClass().getClassLoader(),    
                target.getClass().getInterfaces(), this);
    }    

    @Override    
    /** 
     * ͬ�����������÷������Ƚ����������. 
     * @param proxy --������� 
     * @param method -- ����,�����÷���. 
     * @param args -- �����Ĳ��� 
     */  
    public Object invoke(Object proxy , Method method, Object[] args) throws Throwable {    
        System.out.println("############����JDK��̬����################");  
        Object result = null;    
        //���䷽��ǰ����  
        System.out.println("��׼��˵hello2121212121��");    
        //����ִ�з���  �൱�ڵ���target.sayHelllo;  
        result=method.invoke(target, args);  
        //���䷽�������.  
        System.out.println("��˵��hell22121o��");    
        return result;    
    }    
} 
