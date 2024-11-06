package br.com.alura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcaoBotao implements ActionListener {
    private JTextField primeiro, segundo;
    private JLabel resultado;

    public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.resultado = resultado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread threadCalculo = new Thread(new TarefaMultiplicacao(primeiro, segundo, resultado), "Thread Calculadora");
        threadCalculo.start();

//        resultado.setText(calculo.multiply(new BigInteger(String.valueOf(valor2))).toString());
    }
}
