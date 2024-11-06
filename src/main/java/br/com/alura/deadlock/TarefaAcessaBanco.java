package br.com.alura.deadlock;

public class TarefaAcessaBanco implements Runnable {
    private final PoolDeConexao pool;
    private final GerenciadorDeTransacao tx;

    public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("Peguei a chave pool");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("comecando a gerenciar transacao");
                tx.begin();
            }
        }
    }
}
