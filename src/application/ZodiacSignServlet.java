package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birthDate = request.getParameter("userBirthDate");
		String userName = request.getParameter("userName");
		Date parsedBirthDate = null;

		try {
			parsedBirthDate = sdf.parse(birthDate);
			sdf.format(parsedBirthDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		LocalDate localDate = parsedBirthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();

		// Áries
		if (month == 3 && day >= 21 || month == 4 && day <= 20) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Áries!");
		}

		// Touro
		if (month == 4 && day >= 21 || month == 5 && day <= 20) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Touro!");
		}

		// Gêmeos
		if (month == 5 && day >= 21 || month == 6 && day <= 20) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Gêmeos!");
		}

		// Câncer
		if (month == 6 && day >= 21 || month == 7 && day <= 21) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Câncer!");
		}

		// Leão
		if (month == 7 && day >= 22 || month == 8 && day <= 22) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Leão!");
		}

		// Virgem
		if (month == 8 && day >= 23 || month == 9 && day <= 22) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Virgem!");
		}

		// Libra
		if (month == 9 && day >= 23 || month == 10 && day <= 22) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Libra!");
		}

		// Escorpião
		if (month == 10 && day >= 23 || month == 11 && day <= 21) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Escorpião!");
		}

		// Sagitário
		if (month == 11 && day >= 22 || month == 12 && day <= 21) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Sagitário!");
		}

		// Capricórnio
		if (month == 12 && day >= 22 || month == 1 && day <= 20) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Capricórnio!");
		}

		// Aquário
		if (month == 1 && day >= 21 || month == 2 && day <= 19) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Aquário!");
		}

		// Peixes
		if (month == 2 && day >= 20 || month == 3 && day <= 20) {

			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Peixes!");
		}

	}

}
