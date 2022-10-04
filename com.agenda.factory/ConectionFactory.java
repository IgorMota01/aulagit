import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionFactory {
    // DADOS DO BANCO DE DADOS QUE SERÁ UTILIZADO
    public static final String USERNAME = "root";
    public static final String PASSWORD = "asl@2020";
    //ENDERECO BD QUE SERA USADO NA APLICACAO - BD/URL:PORTA/BDNAME
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

    /*
    Conexão com banco de dados
    */

    public static Connection createConnectionToMySQL() throws Exception{

        //nome do drive conector utilizado
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception{
        //Recuperar uma conexao com o BD
        Connection con = createConnectionToMySQL();

        //testanto se a conexão é nula
        if (con != null) {
            System.out.println("Conexão obtida com sucesso");
            con.close();
        }
    }
}
