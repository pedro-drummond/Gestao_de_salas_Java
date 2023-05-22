
package Classes;

import java.util.ArrayList;
import java.io.Serializable;

public class Curso implements Serializable {
    private int cod;
    private int alunos = 0;
    private String nome;
    private ArrayList<Integer> dias;
    private Professor professor;
    private int alocado = 0;
    private int codigoSala = 0; 
    
    //construtores
    public Curso(){
        this.cod = 0;
        this.nome = "Nome indefindo";
        dias = new ArrayList<>();
        professor = new Professor();
    }
    public Curso(int cod, String nome){
        this.cod = cod;
        this.nome = nome;
        dias = new ArrayList<>();
        professor = new Professor();
    }
    
    //getters and setters
    public int getCodigo(){
        return codigoSala;
    }
    
    public void setCodigo(int codigo){
        this.codigoSala = codigo;
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }
    
    public String getNomeProfessor(){
        return professor.getNome();
    }
    
    public String getCpfProfessor(){
        return professor.getCpf();
    }
    public int getNumeroAlunos(){
        return alunos;
    }
    public ArrayList<Integer> getDias(){
        return this.dias;
    }
    public void setNumeroAlunos(){
        this.alunos ++;
    }
    
    public void tiraAlunos(){
        this.alunos--;
    }
    
    public int getNumeroALunos(){
        return this.alunos;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNomeECod(String nome, int cod){
        this.nome = nome;
        this.cod = cod;
    }
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    
    public void imprimirDados() {
    System.out.println("Curso: " + getNome());
    System.out.println("Codigo: " + getCod());
    System.out.println("Professor: " + professor.getNome());

    for (int i = 0; i < dias.size(); i++) {
        System.out.print(retornaDiaDaSemana(dias.get(i) + 1) + " | ");
    }
    System.out.println();
}
    
    //Funçoes ------------------------------------------------
    public String retornaDiaDaSemana(int dia)
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
      default:
        return "indefinido";
      }
    }
    
    public void adicionaCursoProfessor(Professor professor, ArrayList<Professor> professores) {
        this.setProfessor(professor);
        if (professor != null) {
            professor.setCodCurso(this.getCod());
        }
    }
    
    public void imprimirNomeECod(){
        System.out.println("Nome" + nome + "| Cod: " + cod);
    }
    public int verificaAlocacao(){
        return this.alocado;
    }
    public boolean disponibilidade(ArrayList<Curso> cursos) {
        ArrayList<Integer> diasC = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            ArrayList<Integer> diass = cursos.get(i).getDias();
            for (int j = 0; j < diass.size(); j++) {
                diasC.add(diass.get(j));
            }
        }
        for (int i = 0; i < this.verificaAlocacao(); i++) {
            for (int j = 0; j < diasC.size(); j++) {
                if (this.dias.get(i) == diasC.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void alocar(int dia){
        alocado ++;
        dias.add(dia);
    }
    
    public void alocaAuto() {
        Colecao salas = Colecao.getInstancia();
        
        int posMaiorSala = 0;
        for (int i = 1; i < salas.getSalas().size(); i++) {
            if (salas.getSalas().get(i).qtdDisponivel() > 0 && salas.getSalas().get(i).getCapacidade() > salas.getSalas().get(posMaiorSala).getCapacidade()) {
                posMaiorSala = i;
            }
        }
        int dia = salas.getSalas().get(posMaiorSala).setAlocar(getCod(), getNumeroAlunos());
        if (dia != -1)
            this.alocar(dia);
    }
}
