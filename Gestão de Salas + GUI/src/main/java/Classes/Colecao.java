
package Classes;

import java.util.*;
import javax.swing.*;
import Classes.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Colecao implements Serializable {
    private static Colecao instancia = null;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Curso> cursos;
    private ArrayList<Sala> salas;
    
    

    private Colecao() {
        
        alunos = new ArrayList<Aluno>();
        professores = new ArrayList<Professor>();
        cursos = new ArrayList<Curso>();
        salas = new ArrayList<Sala>();
    }
    


    public static Colecao getInstancia() {
        if (instancia == null) {
            instancia = new Colecao();
        }
        return instancia;
    }
    
    public void addSala(Sala sala){
        salas.add(sala);
    }
    
    public void removeSala(int identificador){
        for(Sala sala : salas){
            if(sala.getIdentificador() == identificador ){
                salas.remove(sala);
            }
        }
    }
          
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
    public void cadastrarSala(int identificador, int capacidade){
        Sala sala = new Sala(identificador, capacidade);
        addSala(sala);
        
    }
    
    
    public void addProfessor(Professor professor) {
        professores.add(professor);
    }
    
    public void removeProfessor(Professor professor){
        for(Curso curso : cursos){
            if(curso.getNomeProfessor().equals(professor.getNome())){
                Professor e = new Professor("Sem Professor", "", "");
                curso.setProfessor(e);
            }
        }     
    }
    
    //adiciona um curso
    public void addCurso(Curso curso){
        cursos.add(curso);
    }
    
    //adiciona um aluno
    public void adicionaAluno(String nomeCurso){
        for(Curso curso : cursos){
            if(curso.getNome().equals(nomeCurso)){
               curso.setNumeroAlunos();
               return;
            }
        }
    }
    //remove aluno
    public void retiraAluno(String nomeCurso){
        for(Curso curso : cursos){
            if(curso.getNome().equals(nomeCurso)){
               curso.tiraAlunos();
               return;
            }
        }
    }
    
    public ArrayList<Sala> getSalas(){
        return salas;
    }
    
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    
    public ArrayList<Professor> getProfessores() {
        return professores;
    }
    
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    
    //define professor
    public void defineProfessor(String nome, Professor e){
        for(Curso curso : cursos){
            if(curso.getNome().equals(nome)){
               curso.setProfessor(e);
            }
        }
    }
    
    //obtem um aluno através do cpf
    public Aluno retornaAluno(String cpf){
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }
    
    public int getCodigoSala(String nomeProfessor) {
        for (Curso curso : cursos) {
            if (curso.getNomeProfessor().equals(nomeProfessor)) {
                return curso.getCodigo();
            }
        }
        return -1; // retorna -1 caso não seja encontrada nenhuma sala para o professor informado
    }
    
    //obtem um curso atraves do codigo
    public Curso retornaCurso(int cod){
        for(Curso curso : cursos){
            if(curso.getCod() == cod){
               return curso;
            }
        }
        JOptionPane.showMessageDialog(null, "Curso de Código: " + cod + " não encontrado", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    
    //consulta professor através do cpf
    public void consultaProfessor(String cpf){
        for(Professor professor : professores){
            if(professor.getCpf().equals(cpf)){
                JOptionPane.showMessageDialog(null, "Nome: " + professor.getNome()+" " + "\nCPF: " + professor.getCpf()+" " + "\nContato: " + professor.getContato()+" " + "\nCurso Ministrado: " + retornaCurso(professor.getCodCurso()).getNome() +" "+ "\nCódigo da sala: " + getCodigoSala(professor.getNome()) + " " ,  "Dados do Professor", JOptionPane.INFORMATION_MESSAGE);
                return;
            }else{ 
                JOptionPane.showMessageDialog(null,"Professor de CPF: " + cpf + " não foi encontrado.", "Professor não encontrado", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    
    
    //consulta sala através do codigo da sala
    public void consultaSala(int codigo){
        for(Sala sala : salas){
            if(sala.getIdentificador() == codigo){
                 JOptionPane.showMessageDialog(null, "Código da Sala: " + sala.getIdentificador() + "\nCapacidade: " + sala.getCapacidade() + "\nNúmero de Alunos: " + sala.getAlunos() , "Dados da Sala", JOptionPane.INFORMATION_MESSAGE);
                 return;
            }else{ 
                JOptionPane.showMessageDialog(null,"Sala de código: " + codigo + " não foi encontrada.", "Sala não encontrada", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    
    public void consultaAluno(String cpf){

    // Itera pela lista de alunos
    for(Aluno aluno : alunos){
        // Verifica se o CPF do aluno é igual ao CPF fornecido
        if(aluno.getCpf().equals(cpf)){
            
            // Cria um StringBuilder para concatenar os nomes dos cursos do aluno
            StringBuilder sb = new StringBuilder();

            // Itera pela lista de cursos do aluno e adiciona cada nome ao StringBuilder
            for(Curso c : aluno.getCursos()){
                sb.append("Curso: ");
                sb.append(c.getNome());
                sb.append("\nSala: ");
                sb.append( c.getCodigo());
                sb.append("\nProfessor: ");
                sb.append(c.getNomeProfessor());
                sb.append(" \n");
            }

            // Remove a vírgula e o espaço extras no final do StringBuilder
            if(sb.length() > 0){
                sb.setLength(sb.length() - 1);
            }

            // Converte o StringBuilder em uma String
            String result = sb.toString();

            // Exibe os dados do aluno em uma janela de diálogo
            JOptionPane.showMessageDialog(null, "Nome: " + aluno.getNome() + "\nMatricula: " + aluno.getMatricula() + "\nCursos:\n " + result, "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);
            return;
        }/*else{ 
                JOptionPane.showMessageDialog(null,"Aluno de CPF: " + cpf + " não foi encontrado.", "Aluno não encontrado", JOptionPane.ERROR_MESSAGE);
                return;
        }*/
    }
}
    
    //retorna um prfoessor através do cpf
    public Professor retornaProfessor(String cpf){
        for(Professor professor : professores){
            if(professor.getCpf().equals(cpf)){
               return professor;
            }
        }
        //JOptionPane.showMessageDialog(null, "Curso de Código: " + cod + " não encontrado", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    
    //
    public void excluirAluno(String cpf){
        // Itera sobre a lista de alunos
      for (Aluno aluno : alunos) {
          // Verifica se o CPF do aluno atual é igual ao CPF passado como parâmetro
        if (aluno.getCpf().equals(cpf)) {
            // Se sim, exibe uma mensagem informando que o aluno foi excluído e remove o aluno da lista
            JOptionPane.showMessageDialog(null, "O aluno " + aluno.getNome() + " com CPF " + aluno.getCpf() + " Foi ecluido da nossa lista");
            alunos.remove(aluno);
        }
      }
      // Caso nenhum aluno tenha sido encontrado com o CPF passado, exibe uma mensagem informando que o aluno não foi encontrado
      JOptionPane.showMessageDialog(null, "Aluno de CPF: "+ cpf + " não encontrado", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
    }
    
    public void excluirProfessor(String cpf){
        for (Professor professor : professores) {
        if (professor.getCpf().equals(cpf)) {
            JOptionPane.showMessageDialog(null, "O Professor " + professor.getNome() + " com CPF " + professor.getCpf() + "Foi ecluido da nossa lista");
            professores.remove(professor);
            return;
        }
      }
     JOptionPane.showMessageDialog(null, "Professor de CPF: " + cpf + " não encontrado", "Não Encontrado", JOptionPane.ERROR_MESSAGE);        
    }
    
    public void excluirCurso(int codigo){
        for(Curso curso : cursos){
            if(curso.getCod() == codigo){
               JOptionPane.showMessageDialog(null, "O curso " + curso.getNome() + " com Código " + curso.getCod() + "Foi ecluido da nossa lista");
                cursos.remove(curso);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Curso de Código: " + codigo + " não encontrado", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
    }
    
    public boolean buscaCurso(int codigo){
        
        
        for(Curso curso : cursos){
            if(curso.getCod() == codigo){
                Professor professor = new Professor();
                professor.setNome("Sem Nome");
                curso.setProfessor(professor);
                
                JOptionPane.showMessageDialog(null, "Nome do curso: " + curso.getNome() + "\nCódigo: " + curso.getCod() + "\nProfessor: " + curso.getNomeProfessor());               
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Curso de Código: " + codigo + " não encontrado", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public boolean buscaAluno(String cpf){
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, "Nome: " + aluno.getNome() + "\nCPF: " + aluno.getCpf() + "\nContato: " + aluno.getContato());   
                
                return true; // encerra a busca após encontrar o aluno
            }
        }
        JOptionPane.showMessageDialog(null, "Aluno de CPF: "+ cpf + " não encontrado", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
        return false;
    }   
    
    public boolean buscaProfessor(String cpf){
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, "Nome: " + professor.getNome() + "\nCPF: " + professor.getCpf() + "\nContato: " + professor.getContato());               
                return true; // encerra a busca após encontrar o aluno
            }
        }
        JOptionPane.showMessageDialog(null, "Professor de CPF: " + cpf + " não encontrado", "Não Encontrado", JOptionPane.ERROR_MESSAGE);        
        return false;
    }

    public Curso getCurso(String nome){
        for(Curso curso : cursos){
            if(curso.getNome().equals(nome)){
                return curso;
            }
        }
       
        return null;
    }
    
   public void exibeNaTela(){
    StringBuilder mensagem = new StringBuilder();
    mensagem.append("O tamanho do vetor é: ").append(alunos.size()).append("\n\n");
    
    for (Aluno aluno : alunos) {
        mensagem.append("Nome: ").append(aluno.getNome()).append("\n");
        mensagem.append("Contato: ").append(aluno.getContato()).append("\n");
        mensagem.append("CPF: ").append(aluno.getCpf()).append("\n\n");
    }
    
    JOptionPane.showMessageDialog(null, mensagem.toString());
    }
   
   public void salvarDados(){
        try {
            FileOutputStream fileOut = new FileOutputStream("dados.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(alunos);
            out.writeObject(professores);
            out.writeObject(cursos);
            out.writeObject(salas);
            out.close();
            fileOut.close();
            System.out.println("Dados salvos com sucesso!");
        } catch(IOException i) {
            i.printStackTrace();
        }
}

    public void carregarDados(String nomeArquivo) {
            try {
                FileInputStream arquivo = new FileInputStream(nomeArquivo);
                ObjectInputStream objeto = new ObjectInputStream(arquivo);

                // Lê os objetos do arquivo e adiciona nos ArrayLists correspondentes
                alunos = (ArrayList<Aluno>) objeto.readObject();
                professores = (ArrayList<Professor>) objeto.readObject();
                cursos = (ArrayList<Curso>) objeto.readObject();
                salas = (ArrayList<Sala>) objeto.readObject();

                objeto.close();
                arquivo.close();
            } catch (IOException e) {
                System.out.println("Erro ao carregar dados do arquivo: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Classe não encontrada: " + e.getMessage());
            }
    }
    
    // Método responsável por alocar automaticamente os cursos nas salas disponíveis
    public void alocarAutomatico() {
    Colecao c = Colecao.getInstancia(); // Obtém a instância da coleção de cursos e salas

    int posMaiorCurso = 0; // Índice do curso com mais alunos para ser alocado
    int posMaiorSala = 0; // Índice da sala com maior capacidade para alocar cursos
    int qtdAlocadas = 0; // Quantidade de cursos alocados até o momento
    int qtdDesalocadas = 0; // Quantidade de cursos que precisam ser alocados

    // Calcula a quantidade de cursos que precisam ser alocados, ou seja, os cursos que estão desalocados
    for (int i = 0; i < c.getCursos().size(); i++) {
        if (c.getCursos().get(i).getNumeroAlunos() > 0) {
            qtdDesalocadas += (2 - c.getCursos().get(i).verificaAlocacao());
        }
    }

    // Enquanto não alocou todos os cursos que precisam ser alocados
    while (qtdAlocadas < qtdDesalocadas) {
        // Procura o curso com mais alunos para ser alocado
        for (int i = 0; i < c.getCursos().size(); i++) {
            if (c.getCursos().get(i).verificaAlocacao() < 2 && c.getCursos().get(i).getNumeroAlunos() > 0 && c.getCursos().get(i).getNumeroAlunos() > c.getCursos().get(posMaiorCurso).getNumeroAlunos()) {
                posMaiorCurso = i;
            }
        }

        // Procura a sala com maior capacidade para alocar cursos
        for (int i = 0; i < c.getSalas().size(); i++) {
            if (c.getSalas().get(i).qtdDisponivel() > 1 && c.getSalas().get(i).getCapacidade() > c.getSalas().get(posMaiorSala).getCapacidade()) {
                posMaiorSala = i;
            }
        }

        // Alocar o curso na sala encontrada
        int dia = c.getSalas().get(posMaiorSala).setAlocar(c.getCursos().get(posMaiorCurso).getCod(), c.getCursos().get(posMaiorCurso).getNumeroAlunos());

        // Verifica se a alocação foi bem sucedida e atualiza o status do curso
        if (dia != -1) {
            c.getCursos().get(posMaiorCurso).alocar(dia);
            int codSalaAlocada = c.getSalas().get(posMaiorSala).getIdentificador();// obtém o código da sala alocada
            c.getCursos().get(posMaiorCurso).setCodigo(codSalaAlocada);
        }

        qtdAlocadas++;
        for(int i =0; i < c.getCursos().size(); i++){
            if(c.getCursos().get(i).verificaAlocacao() < 2 && c.getCursos().get(i).getNumeroAlunos() > 0 && c.getCursos().get(i).getNumeroAlunos()<= c.getCursos().get(posMaiorCurso).getNumeroAlunos()){
                posMaiorCurso = i;
            }
        }

        // Procura a próxima sala com capacidade suficiente para alocar o próximo curso
        for(int i =0; i < c.getSalas().size(); i++){
            if(c.getSalas().get(i).qtdDisponivel()> 1 && c.getSalas().get(i).getCapacidade() <= c.getSalas().get(posMaiorSala).getCapacidade()){
                posMaiorSala = i;
            }
        }
    }
}

   
}



