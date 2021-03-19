package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class chap_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("        <head>\r\n");
      out.write("                <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("                <title>Add Chapter</title>\r\n");
      out.write("                <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/chap_form.css\"> \r\n");
      out.write("        </head>\r\n");
      out.write("        <body>\r\n");
      out.write("                <form action=\"ChapterServlet\" method=\"POST\" id='form'>\r\n");
      out.write("                        <input type=\"hidden\" name=\"a\" value=\"add\"/>\r\n");
      out.write("                        <input type=\"hidden\" name=\"nid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.novelObj.novelID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("                        <h1 class=\"title\">Add a new Chapter</h1>\r\n");
      out.write("                        <h2>Novel Name: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.novelObj.novelName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <label class=\"chapName\">Chapter Name</label>\r\n");
      out.write("                        <input type=\"text\" name=\"chapname\" id=\"chapname\"/>\r\n");
      out.write("                        <p id=\"chapNameMsg\" style=\"visibility: hidden; color: red\">Chapter name can't be empty</p>\r\n");
      out.write("                        <div>\r\n");
      out.write("                                <label style='font-weight: bold; font-size: 150%'>Content</label> <br>\r\n");
      out.write("                                <textarea name='content' id='content''></textarea>\r\n");
      out.write("                                <p id='contentMsg' style='visibility: hidden; color: red'>Content can't be empty</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"footer\">\r\n");
      out.write("                                <input id=\"add\" type='submit' value='Add'/>\r\n");
      out.write("                                <button id=\"cancel\"><a href='NovelServlet?a=display' style='text-decoration: none; color:#000000'>Cancel</a></button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                </form>\r\n");
      out.write("                <script defer>\r\n");
      out.write("                        const form = document.getElementById(\"form\");\r\n");
      out.write("                        const chapName = document.getElementById(\"chapname\");\r\n");
      out.write("                        const content = document.getElementById(\"content\");\r\n");
      out.write("                        const chapNameMsg = document.getElementById(\"chapNameMsg\");\r\n");
      out.write("                        const contentMsg = document.getElementById(\"contentMsg\");\r\n");
      out.write("                        form.addEventListener(\"submit\", event => {\r\n");
      out.write("                                if (chapName.value === \"\") {\r\n");
      out.write("                                        event.preventDefault();\r\n");
      out.write("                                        chapNameMsg.style.visibility = \"visible\";\r\n");
      out.write("                                }\r\n");
      out.write("                                if (content.value === \"\") {\r\n");
      out.write("                                        event.preventDefault();\r\n");
      out.write("                                        contentMsg.style.visibility = \"visible\";\r\n");
      out.write("                                }\r\n");
      out.write("                        });\r\n");
      out.write("                </script>\r\n");
      out.write("        </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
