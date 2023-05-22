
package Classes;

import java.io.Serializable;
import javax.lang.model.SourceVersion;


public class Pessoa implements Serializable{
    public String nome;
    public String contato;
    public String cpf;

    //construtor
    public Pessoa(){
        this.nome = "";
        this.contato = "";
        this.cpf = "";
    }
    public Pessoa(String nome, String contato, String cpf) {
        this.nome = nome;
        this.contato = contato;
        this.cpf = cpf;
    }
    //setter e getter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    //implementar talvez
    public void imprimirDados(){};
    
    public String toString(){
        return "nome: " + nome + ", contato: " + contato + ", cpf: " + cpf;
    }
    
}
