package tutorial;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        // Create the original object
        Man ron = new Man("Ron", 15, "Devon", "England");
//        Get the class loader from the original object
        ClassLoader ronClassLoader = ron.getClass().getClassLoader();
//        Get all interfaces that the original object implements
        Class[] interfaces = ron.getClass().getInterfaces();
//        Create a proxy for ron object
        Person proxyRon = (Person) Proxy.newProxyInstance(ronClassLoader, interfaces, new PersonInvocationHandler(ron));
//        Call one of our original object's methods on the proxy object
        proxyRon.introduce(ron.getName());
        proxyRon.sayAge(ron.getAge());
        proxyRon.sayWhereFrom(ron.getCity(), ron.getCountry());
    }
}
