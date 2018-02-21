package Classe;

import java.util.function.Predicate;

public class EnumPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer < 10;
    }
}
