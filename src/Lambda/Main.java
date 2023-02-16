package Lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };

        int someNumber1 = 11;
        System.out.println(someNumber1 + " " + isPositive.test(someNumber1));
        int someNumber2 = -5;
        System.out.println(someNumber2 + " " + isPositive.test(someNumber2));

        Predicate<Integer> isPos = x -> x > 0;
        System.out.println(someNumber1 + " " + isPos.test(someNumber1));
        System.out.println(someNumber2 + " " + isPos.test(someNumber2));

        Consumer<String> helloName = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello, " + s + "!");
            }
        };

        String name1 = "Michail";
        helloName.accept(name1);

        String name2 = "Viktor";
        Consumer<String> hiBro = s -> System.out.println("Hi, " + s + "!");
        hiBro.accept(name2);


        Function<Double, Long> roundDoubleToLong = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return round(aDouble);
            }
        };
        Double numberD = 123.112341451;
        Float numberF;
        System.out.println(numberD + " after round = " + roundDoubleToLong.apply(numberD));

        Double numberD2 = 17.876533451;
        Function roundFromDoubleToLong = x -> {
            return (Long) round((Double) x);
        };
        System.out.println(numberD2 + " after round = " + roundFromDoubleToLong.apply(numberD2));


        Supplier bonesThrow1d6 = new Supplier<>() {
            @Override
            public Object get() {
                int maxBone = 20;
                int minBone = 1;
                return (int) (Math.random() * ((maxBone - minBone) + 1) + minBone);
            }
        };
        System.out.println("Bone 1d20 first throw : " + bonesThrow1d6.get());
        System.out.println("Bone 1d20 second throw : " + bonesThrow1d6.get());

        Supplier<Integer> bone1d6 = () -> (int) (Math.random() * 6 + 1);
        System.out.println("Bone 1d6 next throw : " + bone1d6.get());
        System.out.println("Bone 1d6 last throw : " + bone1d6.get());
    }
}