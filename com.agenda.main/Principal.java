import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        ContatoDAO contatoDao = new ContatoDAO();

        Contato contato = new Contato();
        contato.setNome("Igor");
        contato.setIdade(24);
        contato.setDataCadastro(new Date());

        contatoDao.save(contato);
    }
}
