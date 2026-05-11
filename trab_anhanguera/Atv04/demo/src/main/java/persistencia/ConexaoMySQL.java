package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_exemplo";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345";

    // Construtor privado — impede instância, pois é utilitária
    private ConexaoMySQL() {}

    public static Connection conectar() throws SQLException {
        // Lança a exceção em vez de retornar null
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        System.out.println("Conexão realizada com sucesso!");
        return conexao;
    }

    public static void fechar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão encerrada.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}