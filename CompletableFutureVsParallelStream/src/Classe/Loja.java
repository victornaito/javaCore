package Classe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Loja {

    private String name;
    private double price;

    public Loja() {
    }

    public Loja(String name) {
        this.name = name;
    }

    public List<String> getPrice(List<Loja> lojaList){

        double init = System.currentTimeMillis();

        System.out.println("Stream Paralelo");
        List<String> collect = lojaList.parallelStream()
                .map(loja -> String.format("O valor da loja %s eh %.2f ", loja.getName(), loja.getPrice()))
                .collect(Collectors.toList());
        System.out.printf("Tempo de processamento: %.2fs ", (System.currentTimeMillis() - init)/100);
        System.out.println(collect);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return collect;
    }

    public List<String> getPriceCompletableFuture(List<Loja> lojaList){

        double init = System.currentTimeMillis();

        System.out.println("\nStream com getPriceCompletableFuture");
        List<String> collect = lojaList.stream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("O valor da loja %s eh %.2f ", loja.getName(), loja.getPrice())
                )).map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.printf("Tempo de processamento: %.2fs ", (System.currentTimeMillis() - init)/100);
        System.out.println(collect);

        return collect;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
