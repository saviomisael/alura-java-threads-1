package br.com.alura.banheiro;

public class Banheiro {
    private boolean ehSujo = true;

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

        synchronized (this) {
            System.out.println(nome + "Entrando no banheiro");

            while(ehSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + "Fazendo coisa rápida");

            dormeUmPouco(5000);

            this.ehSujo = true;

            System.out.println(nome + "Dando descarga");
            System.out.println(nome + "Lavando a mão");
            System.out.println(nome + "Saindo do banheiro");
        }
    }

    private void esperaLaFora(String nome) {
        System.out.println(nome + ", eca, banheiro tá sujo");
        try {
            this.wait();
        } catch (InterruptedException ignored) {
        }
    }

    public void limpa() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + "batendo na porta");

        synchronized (this) {
            System.out.println(nome + "Entrando no banheiro");

            if (!ehSujo) {
                System.out.println(nome + "não está sujo, vou sair");
                return;
            }

            System.out.println(nome + "Limpando banheiro");
            this.ehSujo = false;

            dormeUmPouco(13000);

            this.notifyAll();

            System.out.println(nome + "saindo do banheiro");
        }
    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();

        synchronized (this) {
            System.out.println(nome + "Entrando no banheiro");

            while(ehSujo) esperaLaFora(nome);

            System.out.println(nome + "Fazendo coisa demorada");

            dormeUmPouco(10000);

            this.ehSujo = true;

            System.out.println(nome + "Dando descarga");
            System.out.println(nome + "Lavando a mão");
            System.out.println(nome + "Saindo do banheiro");
        }
    }

    private static void dormeUmPouco(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
