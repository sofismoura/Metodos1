package com.mycompany.metodo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Metodo1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 192, 203));
        
        JMenuBar menuBar = new JMenuBar();
        JMenu operationsMenu = new JMenu("Operações");
        
        String[] operations = { "Soma", "Subtração", "Multiplicação", "Divisão", "Resto da divisão", 
                                "Dobro", "Quadrado", "Cubo", "Raiz quadrada" };
        
        for (String operation : operations) {
            JMenuItem menuItem = new JMenuItem(operation);
            menuItem.setBackground(new Color(152, 251, 152));
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {                      
                        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
                        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));                      

                        StringBuilder result = new StringBuilder();
                        switch (operation) {
                            case "Soma":
                                result.append("A soma é igual a: ").append(soma(num1, num2));
                                break;
                            case "Subtração":
                                result.append("A subtração é igual a: ").append(subtracao(num1, num2));
                                break;
                            case "Multiplicação":
                                result.append("A multiplicação é igual a: ").append(multiplicacao(num1, num2));
                                break;
                            case "Divisão":
                                result.append(num2 != 0 ? "A divisão é igual a: " + divisao(num1, num2) : "Erro: Divisão por zero.");
                                break;
                            case "Resto da divisão":
                                result.append("O resto da divisão é igual a: ").append(restoDivisao(num1, num2));
                                break;
                            case "Dobro":
                                result.append("O dobro de ").append(num1).append(" é igual a: ").append(dobro(num1));
                                break;
                            case "Quadrado":
                                result.append("Quadrado de ").append(num1).append(" é igual a: ").append(quadrado(num1));
                                break;
                            case "Cubo":
                                result.append("Cubo de ").append(num1).append(" é igual a: ").append(cubo(num1));
                                break;
                            case "Raiz quadrada":
                                result.append(num1 >= 0 ? "A raiz quadrada de " + num1 + " é igual a: " + raizQuadrada(num1) : "Erro: Raiz quadrada de número negativo.");
                                break;
                        }

                        JOptionPane.showMessageDialog(frame, result.toString(), "Resultado = ", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Erro: Insira números reais.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            operationsMenu.add(menuItem);
        }

        menuBar.add(operationsMenu);
        JMenu exitMenu = new JMenu("Sair");
        JMenuItem exitItem = new JMenuItem("Sair");
        exitItem.addActionListener(e -> System.exit(0));
        exitMenu.add(exitItem);
        menuBar.add(exitMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    public static double soma(double a, double b) { return a + b; }
    public static double subtracao(double a, double b) { return a - b; }
    public static double divisao(double a, double b) { return b != 0 ? a / b : Double.NaN; }
    public static double multiplicacao(double a, double b) { return a * b; }
    public static double restoDivisao(double a, double b) { return a % b; }
    public static double dobro(double a) { return a * 2; }
    public static double quadrado(double a) { return a * a; }
    public static double cubo(double a) { return a * a * a; }
    public static double raizQuadrada(double a) { return Math.sqrt(a); }
}
