package br.com.alura.lista;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable {
    private final List<String> list;
    private final int numeroDaThread;
    private final Lista lista;

    public TarefaAdicionarElemento(List<String> lista, int numeroDaThread) {
        this.list = lista;
        this.numeroDaThread = numeroDaThread;
        this.lista = null;
    }

    public TarefaAdicionarElemento(Lista lista, int numeroDaThread) {
        this.lista = lista;
        this.numeroDaThread = numeroDaThread;
        this.list = null;
    }

    @Override
    public void run() {
        if(list != null) {
            for (int i = 0; i < 10; i++) {
                list.add(" Thread " + this.numeroDaThread + " - " + i);
            }
        }

        if(lista != null) {
            for (int i = 0; i < 10; i++) {
                lista.adicionaElemento(" Thread " + this.numeroDaThread + " - " + i);
            }
        }
    }
}
