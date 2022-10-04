
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
// import java.util.List;


public class ContatoDAO {
    /*
     * CRUD
     * c - CREATE
     * r - READ
     * u - UPDATE
     * d - DELETE
     */

    public void save(Contato agenda) {


        
        String sql = "INSERT INTO contato(nome, idade, datacadastro) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = ConectionFactory.createConnectionToMySQL();

            //criando PREPAREDSTATEMENT para executar a query
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionando valores  que sao esperados pela query
            preparedStatement.setString(1, agenda.getNome());
            preparedStatement.setInt(2, agenda.getIdade());

            //setando data de efetuacao do cadastro do registro
            preparedStatement.setDate(3, new Date(agenda.getDataCadastro().getTime()));

            //executando a query
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try{
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            } 
        } catch(Exception e) {
                e.printStackTrace();
            }
        
        } 
    }

    // public List<Contato> getContato() {
    //     String sql = "SELECT * FROM contato";

    //     List<Contato> contatos = new ArrayList<Contato>();

        

    //     Connection conn = null;

    //     PreparedStatement preparedStatement = null;
    // }
}


