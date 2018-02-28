package Classe;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AsyncTest {

    public static void main(String[] args) {
        Async async = new Async();

        long init = System.currentTimeMillis();

        Future<Integer> resourceAsync1 = async.getResourceAsync();
        Future<Integer> resourceAsync2 = async.getResourceAsync();
        Future<Integer> resourceAsync3 = async.getResourceAsync();
        Future<Integer> resourceAsync4 = async.getResourceAsync();

        System.out.println("Enrolando");

        try {
            System.out.println(resourceAsync1.get());
            System.out.println(resourceAsync2.get());
            System.out.println(resourceAsync3.get());
            System.out.println(resourceAsync4.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Tempo de processamento - " + (System.currentTimeMillis() - init));
    }


    private static class Async{
        private Integer i = 0;

        private Future<Integer> getResourceAsync(){
            CompletableFuture<Integer> futureValue = new CompletableFuture<>();

            new Thread(() ->{
                futureValue.complete(getResource());
                }).start();
            return futureValue;
        }

        public Integer getResource(){return i++;}


    }
}