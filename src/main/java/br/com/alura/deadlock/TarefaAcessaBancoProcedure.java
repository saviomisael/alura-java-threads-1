package br.com.alura.deadlock;

public class TarefaAcessaBancoProcedure implements Runnable {
    private final PoolDeConexao pool;
    private final GerenciadorDeTransacao tx;

    public TarefaAcessaBancoProcedure(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
//        Deadlock - Por exemplo foi cozinhar um pegou o oleo depois a panela e o outro pegou a panela e depois o oleo
//        synchronized (tx) {
//            System.out.println("comecando a tx");
//            tx.begin();
//
//            synchronized (pool) {
//                System.out.println("peguei a conexao");
//                pool.getConnection();
//            }
//        }
        synchronized (pool) {
            System.out.println("peguei a conexao");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("comecando tx");
                tx.begin();
            }
        }
    }
}
