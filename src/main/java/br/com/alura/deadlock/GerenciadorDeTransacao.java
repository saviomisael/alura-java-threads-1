package br.com.alura.deadlock;

public class GerenciadorDeTransacao {
    public void begin() {
        System.out.println("Começando a transacao");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
