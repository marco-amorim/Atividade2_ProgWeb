package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Professor, não sei porque mas esse código não funcionou no navegador interno
 * do Eclipse, no entanto no Google Chrome funcionou 100%
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String birthDate = request.getParameter("userBirthDate");
		String userName = request.getParameter("userName");
		Date parsedBirthDate = null;
		MonthDay aries = MonthDay.of(03, 19);
		MonthDay ariesLimit = MonthDay.of(04, 21);

		try {
			parsedBirthDate = sdf.parse(birthDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		MonthDay monthDayBirthDate = MonthDay.of(parsedBirthDate.getMonth(), parsedBirthDate.getDay());

		if (monthDayBirthDate.getMonthValue() == aries.getMonthValue()
				&& monthDayBirthDate.getDayOfMonth() > aries.getDayOfMonth()
				&& monthDayBirthDate.getDayOfMonth() < ariesLimit.getDayOfMonth()) {
			out.println("<br><br> Obrigado por fazer o teste " + userName + ", seu signo é de Aries!");
		}

		// Professor, tentei fazer a lógica para a comparação das datas de várias
		// maneiras,
		// como o ano era irrelevante já que estavamos tentando achar o signo da pessoa,
		// tentei
		// fazer uma logica pegando somente o .getDay() e .getMonth() das datas, mas
		// acabou que
		// nao funcionou, entao descobri o MonthDay e vi que dava para ser usado, mas
		// infelizmente
		// nao tive tempo para continuar o projeto e entregar a tempo, vou continuar com
		// as correções
		// e se não conseguir resolver eu vejo com o Senhor na aula de quarta-feira.

	}

}
