package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ZodiacSignServlet
 */
@WebServlet("/ZodiacSignServlet")
public class ZodiacSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Descubra seu Signo</title></head><body>");

		out.println("<h2> Digite seu Nome e sua Data de Nascimento </h2>");

		out.println("<form action=\"ZodiacSignServlet\" method=\"POST\">"
				+ "Nome: <input type=\"text\" name=\"userName\"><br><br>"
				+ "Data de Nascimento: <input type=\"date\" name=\"userBirthDate\"><br><nr><br><br>"
				+ "<input type=\"submit\" value=\"Descubra seu Signo\"> " + "</form>");

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Descubra seu Signo</title></head><body>");

		out.println("<h2> Digite seu Nome e sua Data de Nascimento </h2>");

		out.println("<form action=\"ZodiacSignServlet\" method=\"POST\">"
				+ "Nome: <input type=\"text\" name=\"userName\"><br><br>"
				+ "Data de Nascimento: <input type=\"date\" name=\"userBirthDate\"><br><nr><br><br>"
				+ "<input type=\"submit\" value=\"Descubra seu Signo\"> " + "</form>");

		out.println("</body></html>");

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String birthDate = request.getParameter("userBirthDate");
		Date parsedBirthDate = null;
		Date aries = null;
		Date ariesLimit = null;

		try {
			parsedBirthDate = sdf.parse(birthDate);
			aries = sdf.parse("03-19");
			ariesLimit = sdf.parse("04-21");

		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (parsedBirthDate.after(aries) && parsedBirthDate.before(ariesLimit)) {
			out.println("<br><br> Voce eh de Aries!");
		} else {
		}

//		out.println(parsedBirthDate);
	}

}
