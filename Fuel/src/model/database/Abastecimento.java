package model.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.database.DB;

public class Abastecimento {

    public static void inserirAbastecimento(String placaDoCarro, Date dataAbastecimento, Double valorCombustivel, Integer qtdCombustivel, String tipoCombustivel, String cnpjPosto) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement("INSERT INTO tbAbastecimento "
                            + "(dataAbastecimento, valorCombustivel, qtdCombustivel,"
                            + "tipoCombustivel, placaDoCarro, cnpjDoPosto)"
                            + "VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setDate(1, dataAbastecimento);
            st.setDouble(2, valorCombustivel);
            st.setInt(3, qtdCombustivel);
            st.setString(4, tipoCombustivel);
            st.setString(5, placaDoCarro);
            st.setString(6, cnpjPosto);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while(rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            }
            else {
                System.out.println("No rows affected!");
            }


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

}