package proxy;


import interfaces.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {
	
	public static void main(String[] args) {
		 ProxyTest pt = new ProxyTestImpl();
		 InvocationHandler hand = new MyHandler(pt);
		 //Proxy.getInvocationHandler(pt);
		// Class<?>[] c = new Class<?>[]{ProxyTest.class}; 
		// ProxyTest ptst=(ProxyTest)Proxy.newProxyInstance(pt.getClass().getClassLoader(),c, hand);
		 ProxyTest ptst=(ProxyTest)Proxy.newProxyInstance(pt.getClass().getClassLoader(), pt.getClass().getInterfaces(), hand);
		 ptst.test();
	}
}
