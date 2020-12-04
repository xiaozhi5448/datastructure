package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface InterfaceHello {
    void sayHello();
}
class Hello implements InterfaceHello{
    @Override
    public void sayHello(){
        System.out.println("hello xiaozhi");
    }
}
class HelloProxy implements InvocationHandler{
    private Object instance;
    public HelloProxy(Object instance){
        this.instance = instance;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        method.invoke(this.instance, args);
        System.out.println("after...");
        return null;
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        Hello hello = new Hello();
        InvocationHandler handler = new HelloProxy(hello);
        InterfaceHello interfaceHello = (InterfaceHello) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                hello.getClass().getInterfaces(), handler);
        interfaceHello.sayHello();
    }
}
