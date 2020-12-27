package proxy.Static;
/**
 * 由于代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐

 */
interface HelloInterface{
    public void sayHello();
}

class Hello implements HelloInterface{
    @Override
    public void  sayHello(){
        System.out.println("hello xiaozhi");
    }
}

class HelloProxy implements HelloInterface{
    HelloInterface instance;
    public HelloProxy(HelloInterface instance){
        this.instance = instance;
    }
    @Override
    public void sayHello(){
        System.out.println("before...");
        instance.sayHello();
        System.out.println("after...");
    }
}
public class StaticProxy {
    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxy(new Hello());
        helloProxy.sayHello();
    }
}
