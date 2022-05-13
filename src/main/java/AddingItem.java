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

public class AddingItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddingItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Name = request.getParameter("Name");
		int Price = Integer.parseInt(request.getParameter("Price"));
		String Description = request.getParameter("Description");
		String PictureLink = request.getParameter("PictureLink");
		String DishDeliveryTime = request.getParameter("DishDeliveryTime");

		Connection con = null;
		try {

			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineFoodOrder", "root", "root");

			String InsertDish = "Insert into Dish (DishName, DishPrice, DishDescription, DishPicture,DishDeliveryTime) Values('?','?','?','?','?')";
			PreparedStatement pstmt = con.prepareStatement(InsertDish);

			pstmt.setString(1, Name);
			pstmt.setInt(2, Price);
			pstmt.setString(3, Description);
			pstmt.setString(4, PictureLink);
			pstmt.setString(5, DishDeliveryTime);

			int Insertnum = pstmt.executeUpdate();

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
