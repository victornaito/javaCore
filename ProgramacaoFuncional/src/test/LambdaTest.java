package test;

import Classe.EnumPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static java.util.Arrays.asList;

public class LambdaTest  {

    public static <T> List<T> filtrar(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();

        for (T l: list) {
            if (predicate.test(l)){
                result.add(l);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list  = asList(0,1,2,3,4,5,11, 12);

        System.out.println(filtrar(list, new EnumPredicate()));
    }
}
