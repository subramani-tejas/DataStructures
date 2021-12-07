package com.codewithtejas.lambda;

import java.util.List;
import java.util.Locale;
import java.util.function.*;

public class LambdaDemo {

    // BinaryOperator interface | takes 2 values and returns 1 value
    public static void showBinaryOperator() {
        // (a, b) --> (a+b) --> (a+b)^2
        BinaryOperator<Integer> add = (a,b) -> (a+b);
        Function<Integer, Integer> square = a -> a*a;

        var result = add.andThen(square).apply(1,4);
        System.out.println(result);
    }

    // predicate | if object satisfies some criteria
    public static void showPredicate() {
        // used to filter data
        // boolean test(T t)
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        System.out.println(isLongerThan5.test("tejas"));

        Predicate<String> hasLeftBracket = str -> str.startsWith("{");
        Predicate<String> hasRightBracket = str -> str.endsWith("}");

        System.out.println(hasLeftBracket.and(hasRightBracket).test("{key=value}"));
        System.out.println((hasLeftBracket.negate().test("{key=value")));
    }

    // function | takes an argument and returns a value
    public static void showFunction() {

        // use apply()
        Function<String, Integer> map = String::length;
        System.out.println(map.apply("Tejas"));

        // json object example
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";
        System.out.println(replaceColon.andThen(addBraces).apply("name:tejas"));

        // using compose (reverse order)
        System.out.println(addBraces.compose(replaceColon).apply("name:tejas"));
    }

    // supplier | give a value and take nothing
    public static void showSupplier() {
        Supplier<Double> getRandom = Math::random;

        // lazy evaluation --> execute Math.random only when we call it
        System.out.println(getRandom.get());
    }

    // consumer/chaining | take a value and return nothing
    public static void showConsumer() {
        List<String> list = List.of("a", "b");
        Consumer<String> print = System.out::println;
        Consumer<String> printUpper = item -> System.out.println(item.toUpperCase(Locale.ROOT));
        list.forEach(print.andThen(printUpper));
    }

    // lambdas, method ref
    public static void show() {

        List<Integer> list = List.of(12, 323, 23);

        /*
            // imperative programming --> if/else, switch, for/while, etc
            // you give instructions
            for (var item : list) {
                System.out.println(item);
            }
        */

        // declarative programming
        // you say what needs to be done
        list.forEach(System.out::println);

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
        // call whatever is relevant
        LambdaDemo.show();
        LambdaDemo.showConsumer();
        LambdaDemo.showSupplier();
        LambdaDemo.showFunction();
        LambdaDemo.showPredicate();
        LambdaDemo.showBinaryOperator();
    }
}
