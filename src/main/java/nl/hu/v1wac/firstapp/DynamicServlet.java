package nl.hu.v1wac.firstapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/DynamicServlet.do")
public class DynamicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value1 = req.getParameter("value_one");
		String value2 = req.getParameter("value_two");
		String method = req.getParameter("submit");

		double valueOne = new Double(value1);
		double valueTwo = new Double(value2);
		double value = 0;

		if (method.equals("x")) {
			value = valueOne * valueTwo;
		} else if (method.equals("/")) {
			value = valueOne / valueTwo;
		} else if (method.equals("-")) {
			value = valueOne - valueTwo;
		} else if (method.equals("+")) {
			value = valueOne + valueTwo;
		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("  <title>Simpele Rekenmachine</title>");
		out.println("  <body>");
		out.println("    <h2>Rekenmachine</h2>");
		out.println("    <h2>De uitkomst is: " + value + "</h2>");
		out.println("  </body>");
		out.println("</html>");
	}
}
