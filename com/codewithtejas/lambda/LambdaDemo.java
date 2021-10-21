package com.codewithtejas.lambda;

public class LambdaDemo {

    public static void show() {

        // as method reference
        // syntax: Class/Object::method
        greet(System.out::println);

        String prefix = "_L_";
        // as Lambda expression
        greet(message -> System.out.println(prefix + message));

        /*
            greet(new Printer() {
                @Override
                public void print(String message) {
                    System.out.println(message);
                }
            });
        */
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    public static void main(String[] args) {
        LambdaDemo.show();
    }

}
