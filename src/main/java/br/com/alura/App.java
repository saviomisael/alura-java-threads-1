package br.com.alura;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Isso é o thread main: " + Thread.currentThread().getName());

        Thread.sleep(30000);
    }

}
