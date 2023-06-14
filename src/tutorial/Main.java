package tutorial;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Man ron = new Man("Ron", 15, "Devon", "England");
        ClassLoader ronClassLoader = ron.getClass().getClassLoader();
        Class[] interfaces = ron.getClass().getInterfaces();

        Person proxyRon = (Person) Proxy.newProxyInstance(ronClassLoader, interfaces, new PersonInvocationHandler(ron));
        proxyRon.introduce(ron.getName());
        proxyRon.sayAge(ron.getAge());
        proxyRon.sayWhereFrom(ron.getCity(), ron.getCountry());
        System.out.println();

        Person proxyRon1 = (Person) Proxy.newProxyInstance(ronClassLoader, new Class[]{Person.class}, new PersonInvocationHandler(ron));
        proxyRon1.introduce(ron.getName());

        System.out.println(Proxy.isProxyClass(ron.getClass()));
        System.out.println(Proxy.isProxyClass(proxyRon.getClass()));
    }
}
