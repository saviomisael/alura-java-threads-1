package br.com.alura.banheiro;

public class TarefaNumero2 implements Runnable {
    private final Banheiro banheiro;

    public TarefaNumero2(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        banheiro.fazNumero2();
    }
}
