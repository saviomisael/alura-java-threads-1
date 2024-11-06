package br.com.alura.deadlock;

public class PoolDeConexao {
    public String getConnection() {
        System.out.println("Emprestando conexao");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "connection";
    }
}
