
package Classes;

import Interface.TelaPrincipal;
import java.util.ArrayList;
import Classes.*;

public class TPJava {

    public static void main(String[] args) {
        //ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        Colecao colecao = Colecao.getInstancia();
        colecao.carregarDados("dados.bin");
        new TelaPrincipal().setVisible(true);
    }
}
