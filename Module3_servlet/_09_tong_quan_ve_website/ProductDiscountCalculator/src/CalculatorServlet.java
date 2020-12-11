import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String price = request.getParameter("listPrice");
        String name = request.getParameter("nameProduct");
        String discount = request.getParameter("discountPercent");

        double allPrice = Double.parseDouble(price) * Double.parseDouble(discount) * 0.01;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Name: " + name);
        writer.println("Price: " + allPrice);
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
