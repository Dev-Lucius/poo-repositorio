package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.ConexaoMySQL;

public class Main {

    public static void main(String[] args) {

        // Executando Projeto
        // mvn clean package
        // java -jar target/demo-1.0-SNAPSHOT.jar

        System.out.println("Hello World");


        String sql = "SELECT * FROM clientes";

        try(Connection con = ConexaoMySQL.conectar()) {

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                System.out.println(
                        "ID: " + id +
                        ", Nome: " + nome +
                        ", Email: " + email
                );
                // SAÌDA
                /*
                    Hello World
                    Conexão realizada com sucesso!
                    ID: 1, Nome: João Silva, Email: joao@example.com
                    ID: 2, Nome: Maria Oliveira, Email: maria@example.com
                    ID: 3, Nome: Carlos Souza, Email: carlos@example.com
                */
            }

        } catch (SQLException e) {

            System.out.println("Error, " + e.getMessage());

        }

    }

}