package org.mixit.kotlin;

public class CallFromJava {

    public static void main(String[] args) {
        Person p = new Person("Humbert", "Nadia");
        System.out.println(p.getName());
    }
}
