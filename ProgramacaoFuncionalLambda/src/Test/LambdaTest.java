package Test;


import Classe.Carro;
import Interface.CarroPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class LambdaTest {

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
        List<Carro> list = asList(new Carro("gol", 4L, "fiat"), new Carro("gol", 2L, "fiat"),
                new Carro("gol", 2L, "Honda"),new Carro("gol", 2L, "Honda"));

        System.out.println(filtrar(list, new Predicate<Carro>() {
            @Override
            public boolean test(Carro carro) {
                return carro.getMarca().equals("Honda");
            }
        }));

        System.out.println(filtrar(list, (Carro carro) -> carro.getMarca().equals("fiat")));
    }
}
