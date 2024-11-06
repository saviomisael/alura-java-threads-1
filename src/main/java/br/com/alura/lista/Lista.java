package br.com.alura.lista;

public class Lista {
    private String[] elementos = new String[100];
    private int indice = 0;

    public synchronized void adicionaElemento(String elemento) {
        this.elementos[indice] = elemento;
        this.indice++;

//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        if(this.indice == this.elementos.length) {
            System.out.println("lista tá cheia, notificando");
            this.notify();
        }
    }

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }

    public boolean estaCheia() {
        return indice == tamanho();
    }
}
