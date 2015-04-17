package huilai.kezhenxu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kezhenxu on 4/17/15.
 */
@WebServlet ( "/sys/exception" )
public class ExceptionHandler extends HttpServlet {

	protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws
			ServletException,
			IOException {

	}

	protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws
			ServletException,
			IOException {
		doPost ( request, response );
	}
}
