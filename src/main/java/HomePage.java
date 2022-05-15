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

public class HomePage {
    private static final long serialVersionUID = 1L;

    public HomePage() {
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

            String Dishes = "select * from Dish";
            PreparedStatement pstmt = con.prepareStatement(Dishes);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html lang=\"en\">\r\n"
                    + "<head>\r\n"
                    + "    <meta charset=\"UTF-8\">\r\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                    + "    <!--Style-->\r\n"
                    + "    <link rel=\"stylesheet\" href=\"style.css\">\r\n"
                    + "    <!--Font-->\r\n"
                    + "    <link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap\" rel=\"stylesheet\">\r\n"
                    + "    <!--Icons-->\r\n"
                    + "    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" rel=\"stylesheet\">\r\n"
                    + "    <title>Tasty Food</title>\r\n"
                    + "</head>\r\n"
                    + "<body>\r\n"
                    + "    <!--Header-->\r\n"
                    + "    <input type=\"checkbox\" id=\"cart\">\r\n"
                    + "    <label for=\"cart\" class=\"label-cart\"><span class=\"fas fa-shopping-cart\"></span></label>\r\n"
                    + "    \r\n"
                    + "    <h3 class=\"logo\">Tasty Food</h3>\r\n"
                    + "\r\n"
                    + "    <!--Side bar-->\r\n"
                    + "    <div class=\"sidebar\">\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-search\"></span>\r\n"
                    + "            <a href=\"#\">Search</a>\r\n"
                    + "        </div>\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-home\"></span>\r\n"
                    + "            <a href=\"#\">Home</a>\r\n"
                    + "        </div>\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-heart\"></span>\r\n"
                    + "            <a href=\"#\">Favs</a>\r\n"
                    + "        </div>\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-user\"></span>\r\n"
                    + "            <a href=\"#\">Profile</a>\r\n"
                    + "        </div>\r\n"
                    + "        <div class=\"sidebar-menu\">\r\n"
                    + "            <span class=\"fas fa-sliders-h\"></span>\r\n"
                    + "            <a href=\"#\">Setting</a>\r\n"
                    + "        </div>\r\n"
                    + "    </div>");
            out.println("<div class=\"dashboard\">\r\n"
                    + "        <div class=\"dashboard-banner\">\r\n"
                    + "            <img src=\"C:\\CODES\\Food Site\\IMAGES\\Banner.jpg\">\r\n"
                    + "            <div class=\"banner-promo\">\r\n"
                    + "                <h1><span>50% OFF</span>\r\n"
                    + "                Tasty Food<br>\r\n"
                    + "                Between Your Hand</h1>\r\n"
                    + "            </div>\r\n"
                    + "        </div>\r\n"
                    + "\r\n"
                    + "        <h3 class=\"dashboard-title\">Recommended Food For You</h3>\r\n"
                    + "        <div class=\"dashboard-menu\">\r\n"
                    + "            <a href=\"#\">Favorites</a>\r\n"
                    + "            <a href=\"#\">Best Seller</a>\r\n"
                    + "            <a href=\"#\">Near Me</a>\r\n"
                    + "            <a href=\"#\">Promotion</a>\r\n"
                    + "            <a href=\"#\">Top Rated</a>\r\n"
                    + "            <a href=\"#\">ALL</a>\r\n"
                    + "        </div>");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DishName = rs.getString("DishName");
                DishPrice = rs.getInt("DishName");
                DishDescription = rs.getString("DishDescription");
                DishPicture = rs.getString("DishPicture");
                DishDeliveryTime = rs.getString("DishDeliveryTime");

                out.println(" <div class=\"dashboard-card\">\r\n"
                        + "    <img class=\"card-image\" src=\"" + DishPicture + "\">\r\n"
                        + "<div class=\"card-detail\">\r\n"
                        + "    <h4>" + DishName + "<span>" + DishPrice + "$</span></h4>\r\n"
                        + "    <p>" + DishDescription + " </p>\r\n"
                        + "    <p class=\"card-time\"><span class=\"fas fa-clock\"></span>" + DishDeliveryTime
                        + "</p>\r\n"
                        + "    <input type=\"checkbox\"  name=\"check\" value=\"" + DishName + "\">\r\n"
                        + "</div>\r\n"
                        + "        </div>");
            }

            out.println("</div>\r\n"
                    + "    </div>\r\n"
                    + "    \r\n"
                    + "    \r\n"
                    + "</body>\r\n"
                    + "</html>");
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
