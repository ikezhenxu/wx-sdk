package huilai.kezhenxu.servlet;

import huilai.kezhenxu.material.WxArticle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kezhenxu on 4/19/15.
 */
@WebServlet ( "/mat/publish.api" )
public class PublishArticleServlet extends HttpServlet {

	protected void doPost ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		try {
			WxArticle article = new WxArticle ()
					.setTitle ( "第一个" )
					.setAuthor ( "kezhenxu" );
		} catch ( Exception e ) {

		}
	}

	protected void doGet ( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		doPost ( request, response );
	}
}
