package aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class Aplicacao {
    
    private final String url =  "jdbc:postgresql://127.0.0.1/Mauricio";
    
    private final String user = "postgres";
    
    private final String password = "drac123";

    public Connection connect()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the SQL Server successfully!!");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public static void main(String[] args) throws SQLException 
    {
        Aplicacao app = new Aplicacao();
        
        Connection con = app.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT VERSION()");
        ResultSetMetaData rsmd;
        
        Scanner input = new Scanner(System.in);
        int opcao;
        ArrayList<String> dados = new ArrayList<>();
        
        System.out.println("\nAPLICACAO TESTE PARA BANCO DE DADOS");
        System.out.println("ACESSO APENAS A TABELA PUBLICADORA\n");
        
        if (rs.next())
        {
            System.out.println(rs.getString(1) + "\n");
        }
        
        do
        {
            System.out.println("SELECIONA A ACAO:");
            System.out.println("1. INSERT INTO Publicadora");
            System.out.println("2. SELECT * FROM Publicadora");
            System.out.println("3. DELETE FROM Publicadora");
            System.out.println("4. UPDATE Publicadora");
            System.out.println("5. SAIR");
            
            do
            {
                opcao = input.nextInt();
            }
            while (opcao > 5 || opcao < 1);
                switch (opcao)
                {
                    case 1:
                        System.out.println("CNPJPublic: ");
                        dados.add(input.next());
                        System.out.println("Nome: ");
                        dados.add(input.next());
                        System.out.println("Email: ");
                        dados.add(input.next());
                        
                        
                        st.executeUpdate("INSERT INTO \"Publicadora\"(\"CNPJPublic\", \"Nome\", \"Email\") VALUES(" +
                                "\'" + dados.get(0) + "\'" +  ", " + "\'" + dados.get(1) + "\'" +  ", " + 
                                 "\'" + dados.get(2) + "\'" + ");");
                        dados.clear();
                        break;

                    case 2:
                        rs = st.executeQuery("SELECT * FROM \"Publicadora\"");
                        while (rs.next())
                        {
                        rsmd = rs.getMetaData();
                        System.out.println(rs.getString("CNPJPublic"));
                        System.out.println(rs.getString("Nome"));
                        System.out.println(rs.getString("Email"));
                        }
                        break;

                    case 3:
                        System.out.println("Inform the Column that you want to use to compare: ");
                        dados.add(input.next());
                        System.out.println("Inform the value wanted \n" +
                                "The colum containing the following value will have the row deleted: ");
                        dados.add(input.next());

                        st.executeUpdate("DELETE FROM \"Publicadora\" WHERE " + "\"" + dados.get(0) + "\"" +
                                 "= '" + dados.get(1) + "'" );

                        dados.clear();
                        break;

                    case 4:
                        System.out.println("Inform the column that you want to update: ");
                        dados.add(input.next());
                        System.out.println("Inform the data that you want to be inserted: ");
                        dados.add(input.next());
                        System.out.println("Inform the column that you want to be compared: ");
                        dados.add(input.next());
                        System.out.println("Inform the data that it will be compared: ");
                        dados.add(input.next());

                        st.executeUpdate("UPDATE \"Publicadora\" SET " + "\"" + dados.get(0) + "\"" +
                                " = '" + dados.get(1) + "' WHERE " + "\"" + dados.get(2) + "\"" + 
                                " = '" + dados.get(3) + "'");
                        break;

                    default:
                        System.out.println("SAINDO DA APLICACAO");
        }
        }
        while (opcao != 5);
        con.close();
        st.close();
        rs.close();
    }
    
}
