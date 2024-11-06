package br.com.alura.banheiro;

public class TarefaLimpeza implements Runnable {
    private final Banheiro banheiro;

    public TarefaLimpeza(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        while (true) {
            banheiro.limpa();
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
