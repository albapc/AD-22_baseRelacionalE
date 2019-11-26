package baserelacionale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alba
 */
public class BaseRelacionalE {

    public static Connection conn = null;
    
    private Connection conexion() {
        final String driver = "jdbc:oracle:thin:";
        final String host = "localhost.localdomain";
        final String porto = "1521";
        final String sid = "orcl";
        final String usuario = "hr";
        final String password = "hr";
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;

//        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void listarDatos() {
        ArrayList<Produtos> prods = new ArrayList<Produtos>();
        String sql = "SELECT produtos.* FROM produtos";

        try (Connection conn = this.conexion();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                Produtos pro = new Produtos();

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    if (rsmd.getColumnType(i) == Types.VARCHAR) {
                        if (rsmd.getColumnName(i).equalsIgnoreCase("CODIGO")) {
                            pro.setCodigo(rs.getString(i));
                        } else {
                            pro.setDescricion(rs.getString(i));
                        }
                    } else if (rsmd.getColumnType(i) == Types.NUMERIC) {
                        pro.setPrezo(rs.getInt(i));
                    }
                }           
                prods.add(pro);
            }
            System.out.println(prods);

        } catch (SQLException ex) {
            Logger.getLogger(BaseRelacionalE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        BaseRelacionalE obx = new BaseRelacionalE();
        
        obx.listarDatos();
        conn.close();
    }

}
