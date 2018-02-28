package LojaTest;

import Classe.Loja;

import java.util.List;

import static java.util.Arrays.asList;

public class LojaTest {
    public static void main(String[] args) {
        List<Loja> lojaList = asList(new Loja("Wallmart"),
                new Loja("Wallmart2"),
                new Loja("Wallmart3"),
                new Loja("Wallmart4"),
                new Loja("Wallmart5"),
                new Loja("Wallmart6"),
                new Loja("Wallmart7"),
                new Loja("Wallmart8"),
                new Loja("Wallmart9"));

        Loja loja = new Loja();
        loja.getPrice(lojaList);
        loja.getPriceCompletableFuture(lojaList);
    }
}
