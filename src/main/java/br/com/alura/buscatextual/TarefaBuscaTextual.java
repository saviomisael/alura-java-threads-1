package br.com.alura.buscatextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {
    private final String file;
    private final String nome;

    public TarefaBuscaTextual(String file, String nome) {
        this.file = file;
        this.nome = nome;
    }

    @Override
    public void run() {
        try(Scanner scanner = new Scanner(new File(file))) {
            int numeroDaLinha = 1;

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();

                if(linha.toLowerCase().contains(nome.toLowerCase())) {
                    System.out.println(file + " - " + numeroDaLinha + " - " + linha);
                }

                numeroDaLinha++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
