package br.com.alura.lista;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Lista lista = new Lista();

        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }

        new Thread(new TarefaImprimir(lista)).start();

        Thread.sleep(2000);

//        List<String> lista = Collections.synchronizedList(new ArrayList<>());
//
//        synchronized (lista) {
//            Iterator i = lista.iterator(); // Must be in synchronized block
//            while (i.hasNext())
//                foo(i.next());
//        }

//        List<String> lista = new Vector<>();
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(new TarefaAdicionarElemento(lista, i)).start();
//        }
//
//        Thread.sleep(2000);
//
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(i + " - " + lista.get(i));
//        }
//
//        lista.stream().forEach(System.out::println);
    }
}
