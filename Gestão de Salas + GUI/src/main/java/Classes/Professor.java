
package Classes;

import java.util.Scanner;
import java.io.Serializable;

public class Professor extends Pessoa implements Serializable{
    public int codCurso;
    public Professor() {}

    public Professor(String nome, String cpf, String contato) {
        super(nome, cpf, contato);
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void imprimirDados() {
        super.imprimirDados();
    }

    public void novosDados(String nome, String cpf, String contato) {
        super.setNome(nome);
        super.setCpf(cpf);
        super.setContato(contato);
    }

}