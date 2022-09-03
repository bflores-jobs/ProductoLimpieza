package cl.bflores.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.bflores.facade.Facade;

/**
 * Servlet implementation class ProcesaLogin
 * Obtiene los datos de usuario y contraseña del formulario login, valida que sean correctos
 * si los datos son correctos crea sesion y redirige a ingresa valores, si no envia mensaje y redirige a login
 */
@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// persistencia de datos de usuario y contraseña
		Facade facade = new Facade();
		
		// Obtiene datos de usuario y contraseña ingresados en el formulario login por el usuario
		String requestLogin = request.getParameter("login");
		String requestPass = request.getParameter("pass");
		
		// Instancia de PrintWriter para mensaje
		PrintWriter out = response.getWriter();
		
		// Compara valores persistente con los ingresados por el usuario
		if(!facade.usuarioRegistrado(requestLogin, requestPass)) {
			// Envía mensaje por datos incorrectos
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Usuario o contraseña incorrectos');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}else {
			// Si los datos son correctos crea sesion, envía los datos y redirige a ingresa valores
			HttpSession session = request.getSession(true);
			session.setAttribute("requestLogin", requestLogin);
			session.setMaxInactiveInterval(0);	
			
			// lee cookies
			Cookie[] cookies = request.getCookies();
			String lastLogin = "";
			String dia = "";
			String hora = "";
			Date fecha = new Date();
			SimpleDateFormat simpleDateFormatDia = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat simpleDateFormatHora = new SimpleDateFormat("hh:mm");

			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("dia")) {
					dia = cookies[i].getValue();
				}
				if (cookies[i].getName().equals("hora")) {
					hora = cookies[i].getValue();
				}
			}

			if (dia.isEmpty() || hora.isEmpty()) {
				dia = simpleDateFormatDia.format(fecha);
				hora = simpleDateFormatHora.format(fecha);
			}

			lastLogin = "Anterior ingreso: " + dia + " " + hora;
			dia = simpleDateFormatDia.format(fecha);
			hora = simpleDateFormatHora.format(fecha);
			Cookie cookieDia = new Cookie("dia", dia);
			Cookie cookieHora = new Cookie("hora", hora);
			response.addCookie(cookieDia);
			response.addCookie(cookieHora);

			request.setAttribute("lastLogin", lastLogin);
								
			request.getRequestDispatcher("listarProductos").forward(request, response);
			
		}
	}

}
