package br.pucrs.bruno.laitano;

import java.util.Scanner;

public class App {
    private NextDate nd;
    private String input;
    private Scanner in;

    public App(){
        this.in = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Digite uma data (dd/mm/aaaa): ");
        this.input = in.nextLine();
        this.nd = new NextDate(input);
        if (!nd.sizeValidation())
            System.out.println("ERRO: tamanho inválido!");
        else if (!nd.digitsValidation())
            System.out.println("ERRO: não utilizou dígitos!");
        else if (!nd.formatValidation())
            System.out.println("ERRO: não utilizou '/'!");
        else if (!nd.dayValidation() || !nd.monthValidation() || !nd.yearValidation())
            System.out.println("ERRO: data inválida!");
        else
            System.out.println("Data seguinte: \n" + nd.nextDate());
    }
}