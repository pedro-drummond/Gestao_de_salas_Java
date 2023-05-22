
package Classes;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Sala implements Serializable{
    private int identificador;
    private int alunos;
    private int maxUsada;
    private int capacidade;
    private int[] disponivel = {0, 0, 0, 0, 0};
    public static final int SEMANA = 5;
    private ArrayList<String> semana = new ArrayList<>();

    //construtor
    public Sala() {
        this.identificador = -1;
        this.capacidade = -1;
        alunos = 0;
        for (int i = 0; i < SEMANA; i++) {
            semana.add("Disponivel");
        }
    }

    public Sala(int identificador, int capacidade) {
        this.identificador = identificador;
        this.capacidade = capacidade;
        alunos = 0;
        for (int i = 0; i < SEMANA; i++) {
            semana.add("Disponivel");
        }
    }
    
    public int getDisponivel(int i){
        return disponivel[i];
    }
    
    
    public void setMaxUsada(){
        this.maxUsada = 1;
    }
    
    public int getMaxUsada(){
        return this.maxUsada;
    }
    
    //getter and setter
    public int getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }

    public int getAlunos() {
        return this.alunos;
    }

    public void subAlunos() {
        this.alunos--;
    }

    public void sumAlunos() {
        this.alunos++;
    }

    //funçoes ------------------------------------------------------
    
    public void relatorio() {
    
        System.out.println("[RELATORIO SALA " + identificador + " ]");
        System.out.println("Capacidade: " + capacidade + " | Alunos: " + alunos + "\n");
        for (int i = 0; i < SEMANA; i++) {
            if (disponivel[i] == 0)
                System.out.println(diaDaSemana(i + 1) + ": " + semana.get(i));
            else
                System.out.println(diaDaSemana(i + 1) + ": " + disponivel[i]);
        }
    }
    
    public int setAlocar(int codigo, int alunos) {
    for (int i = 0; i < 5; i++) {
        if (disponivel[i] == 0) {
            disponivel[i] = codigo;
            setAlunos(alunos);
            return i;
        }
     
    }
    return -1;
    }
    
    public int qtdDisponivel() {
        int qtd = 0;
        for (int i = 0; i < 5; i++) {
            if (disponivel[i] == 0)
                qtd++;
        }
        return qtd;
    }
    
    public String diaDaSemana(int dia)
    {
      switch (dia)
      {
      case 1:
        return "Segunda-Feira";
      case 2:
        return "Terça-Feira";
      case 3:
        return "Quarta-Feira";
      case 4:
        return "Quinta-Feira";
      case 5:
        return "Sexta-Feira";
      }
      return "Indefinido";
    }
        
    
}
    



    