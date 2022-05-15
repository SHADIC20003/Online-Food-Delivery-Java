import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.jar.Attributes.Name;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class HighestOrders {
    private static final long serialVersionUID = 1L;

    public HighestOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String DishName;
        int DishPrice;
        String DishDescription;
        String DishPicture;
        String DishDeliveryTime;
        Connection con = null;
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineFoodOrder", "root", "root");

            String LowestOrder = "select * FROM (Select from Dish Order by NumberOfOrders ASC)  where rownum <= 1;";

            PreparedStatement pstmt = con.prepareStatement(LowestOrder);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DishName = rs.getString("DishName");
                DishPrice = rs.getInt("DishName");
                DishDescription = rs.getString("DishDescription");
                DishPicture = rs.getString("DishPicture");
                DishDeliveryTime = rs.getString("DishDeliveryTime");
            }

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
    }

}
