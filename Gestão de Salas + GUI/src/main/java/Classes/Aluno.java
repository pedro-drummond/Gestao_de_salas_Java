
package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Pessoa implements Serializable {
    private int matricula;
    private ArrayList<Curso> cursos;
    
public Aluno() {
    super();
    matricula = 1000;
    cursos = new ArrayList<>();
}

public Aluno(String nome, String cpf, String contato, int matricula) {
    super(nome, cpf, contato);
    this.matricula = matricula;
    cursos = new ArrayList<Curso>();
}

public void setMatricula(int matricula) {
    this.matricula = matricula;
}

public void setCurso(Curso curso) {
    cursos.add(curso);
    //curso.setNumeroAlunos(curso.getNumeroAlunos() + 1);
}

public int getMatricula() {
    return matricula;
}

public ArrayList<Curso> getCursos() {
    return cursos;
}

public Curso getCurso(){
    for(Curso curso : cursos){
        return curso;
    }
    
    return null;
}


public void preencherDadosAluno(ArrayList<Aluno> alunos, ArrayList<Curso> cursos) {
    // Implementação omitida
}

public void imprimirDadosAluno() {
    super.imprimirDados();
    System.out.println("Matricula: " + matricula);
}

public boolean dataCompativel(Curso curso) {
    // Implementação omitida
    return false;
}

public void adicionarCurso(Curso curso) {
    if (!verificaDuplicidade(curso) && curso.disponibilidade(cursos)) {
        setCurso(curso);
        
    }
}

public boolean verificaDuplicidade(Curso curso) {
    int end = cursos.size();
    for (int i = 0; i < end; i++) {
        if (cursos.get(i).getCod() == curso.getCod()) {
            return true;
        }
    }
    return false;
}

public static boolean visualizar(ArrayList<Aluno> alunos, String cpf) {
    int end = alunos.size();
    int endCurso;
    for (int i = 0; i < end; i++) {
        if (cpf.compareTo(alunos.get(i).getCpf()) == 0) {
            System.out.println("Nome : " + alunos.get(i).getNome());
            System.out.println("Matricula: " + alunos.get(i).getMatricula());
            System.out.println("Cursos : ");
            endCurso = alunos.get(i).getCursos().size();
            for (int j = 0; j < endCurso; j++) {
                alunos.get(i).getCursos().get(j).imprimirNomeECod();
                System.out.print("Ocorrencia: ");
                alunos.get(i).getCursos().get(j).imprimirDados();
                System.out.println();
                return true;
            }
        }
    }
    return false;
}

}

