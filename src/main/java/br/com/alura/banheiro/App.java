package br.com.alura.banheiro;

public class App {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "convidado 1 ");
        Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "convidado 2 ");
        Thread limpeza = new Thread(new TarefaLimpeza(banheiro), "limpeza ");

//         Um GarbageCollector é uma thread daemon
        limpeza.setDaemon(true); // só vai rodar enquanto as outras threads estão rodando

//        convidado1.setPriority(Thread.MAX_PRIORITY); // a prioridade padrão é 5 e a máxima 10

        convidado1.start();
        convidado2.start();
        limpeza.start();
    }
}
