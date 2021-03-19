package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_005fnovel_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private static final String _jspx_encoding = "UTF-8";
  private boolean _jspx_gen_bytes = true;
  private boolean _jspx_encoding_tested;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items_end_begin;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_end_begin;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  private static byte[] _jspx_getBytes(String s) {
    try {
      return s.getBytes(_jspx_encoding);
    } catch (java.io.UnsupportedEncodingException ex) {
    }
    return null;
  }

  private boolean _jspx_same_encoding(String encoding) {
    if (! _jspx_encoding_tested) {
      _jspx_gen_bytes = _jspx_encoding.equals(encoding);
      _jspx_encoding_tested = true;
    }
    return _jspx_gen_bytes;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_forEach_var_items_end_begin.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_forEach_end_begin.release();
    _jspx_tagPool_c_when_test.release();
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
      			null, true, 0, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_0, _jspx_array_0S);
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_1, _jspx_array_1S);
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_2, _jspx_array_2S);
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_1, _jspx_array_1S);
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_8, _jspx_array_8S);
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_15, _jspx_array_15S);
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_19, _jspx_array_19S);
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${novelName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_20, _jspx_array_20S);
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_1, _jspx_array_1S);
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_28, _jspx_array_28S);
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("begin");
    _jspx_th_c_set_0.setValue(new String("0"));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("end");
    _jspx_th_c_set_1.setValue(new String("5"));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tagList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setBegin(0);
    _jspx_th_c_forEach_0.setEnd(4);
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_3, _jspx_array_3S);
          if (_jspx_meth_c_forEach_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_6, _jspx_array_6S);
          if (_jspx_meth_c_set_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_7, _jspx_array_7S);
          if (_jspx_meth_c_set_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_1, _jspx_array_1S);
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_end_begin.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.tagListObj}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("tag");
    _jspx_th_c_forEach_1.setBegin(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${begin}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_1.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${end}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_4, _jspx_array_4S);
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tag.tagID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_5, _jspx_array_5S);
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items_end_begin.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tag.getTagName()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_2.setVar("begin");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${begin+7}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_set_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_3.setVar("end");
    _jspx_th_c_set_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${end+7}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_9, _jspx_array_9S);
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_9, _jspx_array_9S);
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_14, _jspx_array_14S);
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_10, _jspx_array_10S);
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_11, _jspx_array_11S);
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_12, _jspx_array_12S);
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.avatarURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_13, _jspx_array_13S);
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${DUPLICATEDNOVELERROR != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_16, _jspx_array_16S);
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${DUPLICATEDNOVELERROR}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_17, _jspx_array_17S);
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dupNovelObj.novelID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_18, _jspx_array_18S);
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${TAGERROR != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_21, _jspx_array_21S);
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${TAGERROR}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_22, _jspx_array_22S);
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    HttpServletResponse response = (HttpServletResponse)_jspx_page_context.getResponse();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${applicationScope.tagListObj}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("tag");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_23, _jspx_array_23S);
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tag.tagID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_24, _jspx_array_24S);
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tag.tagName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_25, _jspx_array_25S);
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tag.tagID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_26, _jspx_array_26S);
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tag.tagID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          ((org.apache.jasper.runtime.JspWriterImpl)out).write(_jspx_same_encoding(response.getCharacterEncoding()), _jspx_array_27, _jspx_array_27S);
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
  private final static String _jspx_array_0S = "\r\n\r\n\r\n\r\n<!DOCTYPE html>\r\n<html>\r\n        <head>\r\n                <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n                <title>Insert Novel</title>\r\n                <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/index.css\"> \r\n                <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/insert_novel_form.css\"> \r\n                <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\r\n        </head>\r\n        <body>\r\n                <div class=\"navbar\">\r\n                        <img src=\"images/logo.svg\" alt=\"Logo-unclickable\" id=\"logo\">\r\n                        <a class=\"home\" href=\"NovelServlet\">Home</a>\r\n                        <div class=\"dropdown\">\r\n                                <a class=\"drop-btn\" href=\"#\">Category <i class=\"fa fa-caret-down\"></i></a>\r\n                                        ";
  private final static byte[] _jspx_array_0 = _jspx_getBytes(_jspx_array_0S);
  private final static String _jspx_array_1S = "\r\n                                        ";
  private final static byte[] _jspx_array_1 = _jspx_getBytes(_jspx_array_1S);
  private final static String _jspx_array_2S = "\r\n                                <ul class=\"dropdown-content\">\r\n                                        ";
  private final static byte[] _jspx_array_2 = _jspx_getBytes(_jspx_array_2S);
  private final static String _jspx_array_3S = "\r\n                                                <div class=column>\r\n                                                        ";
  private final static byte[] _jspx_array_3 = _jspx_getBytes(_jspx_array_3S);
  private final static String _jspx_array_4S = "\r\n                                                                <li><a class=\"tag\" href=\"NovelServlet?a=searchtag&id=";
  private final static byte[] _jspx_array_4 = _jspx_getBytes(_jspx_array_4S);
  private final static String _jspx_array_5S = "</a></li>\r\n                                                                ";
  private final static byte[] _jspx_array_5 = _jspx_getBytes(_jspx_array_5S);
  private final static String _jspx_array_6S = "\r\n                                                </div>\r\n                                                ";
  private final static byte[] _jspx_array_6 = _jspx_getBytes(_jspx_array_6S);
  private final static String _jspx_array_7S = "\r\n                                                ";
  private final static byte[] _jspx_array_7 = _jspx_getBytes(_jspx_array_7S);
  private final static String _jspx_array_8S = "\r\n                                </ul>\r\n                        </div>\r\n                        ";
  private final static byte[] _jspx_array_8 = _jspx_getBytes(_jspx_array_8S);
  private final static String _jspx_array_9S = "\r\n                                ";
  private final static byte[] _jspx_array_9 = _jspx_getBytes(_jspx_array_9S);
  private final static String _jspx_array_10S = "\r\n                                        <div class=\"login\">\r\n                                                <button><a href=\"LoginServlet\" class=\"login-btn\">Login</a></button>\r\n                                        </div>\r\n                                ";
  private final static byte[] _jspx_array_10 = _jspx_getBytes(_jspx_array_10S);
  private final static String _jspx_array_11S = "\r\n                                        <div class=\"user-mng\">\r\n                                                <img src=\"";
  private final static byte[] _jspx_array_11 = _jspx_getBytes(_jspx_array_11S);
  private final static String _jspx_array_12S = "/images/avatars/";
  private final static byte[] _jspx_array_12 = _jspx_getBytes(_jspx_array_12S);
  private final static String _jspx_array_13S = "\" alt=\"user\" id=\"avatar\">\r\n                                                <ul class=\"user-dropdown\">\r\n                                                        <li><a id=\"Manage\" href=\"ManageAccountServlet\">Manage Account</a></li>\r\n                                                        <li><a id=\"Logout\" href=\"LoginServlet?action=logout\">Logout</a></li>\r\n                                                </ul>\r\n                                        </div>\r\n                                ";
  private final static byte[] _jspx_array_13 = _jspx_getBytes(_jspx_array_13S);
  private final static String _jspx_array_14S = "\r\n                        ";
  private final static byte[] _jspx_array_14 = _jspx_getBytes(_jspx_array_14S);
  private final static String _jspx_array_15S = "\r\n                        <div class=\"search-container\">\r\n                                <form action=\"NovelServlet\" method=\"post\">\r\n                                        <input type=\"hidden\" name=\"a\" value=\"searchname\"/>\r\n                                        <input type=\"text\" placeholder=\"Search..\" id=\"search-bar\" name=\"nameSearch\">\r\n                                        <button id=\"search-btn\" type=\"submit\"><i class=\"fa fa-search\"></i></button>\r\n                                </form>\r\n                        </div>\r\n                </div>\r\n                <form action=\"NovelServlet\" enctype=\"multipart/form-data\" method=\"POST\" id='form'>\r\n                        <input type=\"hidden\" value=\"n_add\" name=\"a\">\r\n                        <fieldset>\r\n                                <legend><h1>Add a novel</h1></legend>\r\n                                ";
  private final static byte[] _jspx_array_15 = _jspx_getBytes(_jspx_array_15S);
  private final static String _jspx_array_16S = "\r\n                                        <p style=\"color: red\">";
  private final static byte[] _jspx_array_16 = _jspx_getBytes(_jspx_array_16S);
  private final static String _jspx_array_17S = "</p>\r\n                                        <button><a href=\"ChapterServlet?a=addchapform&nid=";
  private final static byte[] _jspx_array_17 = _jspx_getBytes(_jspx_array_17S);
  private final static String _jspx_array_18S = "\">Add a new Chapter</a></button>\r\n                                ";
  private final static byte[] _jspx_array_18 = _jspx_getBytes(_jspx_array_18S);
  private final static String _jspx_array_19S = "\r\n                                <div>\r\n                                        <label for=\"coverURL\"><h1>Novel name</h1></label>\r\n                                        <input type=\"text\" name=\"novelName\" id='novelName' value=\"";
  private final static byte[] _jspx_array_19 = _jspx_getBytes(_jspx_array_19S);
  private final static String _jspx_array_20S = "\"/> <label style=\"visibility: hidden; color: red\" id='msg'>Novel name can't be empty</label>\r\n                                </div>\r\n                                <div>\r\n                                        <label for=\"coverURL\"><h1>Cover</h1></label>\r\n                                        <input type=\"file\" name=\"coverURL\" id=\"coverURL\"/>\r\n                                </div>\r\n                                <h1>Tags</h1>\r\n                                <div class=\"tagTable\">\r\n                                        ";
  private final static byte[] _jspx_array_20 = _jspx_getBytes(_jspx_array_20S);
  private final static String _jspx_array_21S = "\r\n                                                <p style=\"color:red\">";
  private final static byte[] _jspx_array_21 = _jspx_getBytes(_jspx_array_21S);
  private final static String _jspx_array_22S = "</p>\r\n                                        ";
  private final static byte[] _jspx_array_22 = _jspx_getBytes(_jspx_array_22S);
  private final static String _jspx_array_23S = "\r\n                                                <span class=\"tag-item\">\r\n                                                        <label for=\"";
  private final static byte[] _jspx_array_23 = _jspx_getBytes(_jspx_array_23S);
  private final static String _jspx_array_24S = "\" class=\"tagname\">";
  private final static byte[] _jspx_array_24 = _jspx_getBytes(_jspx_array_24S);
  private final static String _jspx_array_25S = "</label>\r\n                                                        <input type=\"checkbox\" class=\"tagItem\" style=\"border: 1px solid black; visibility: hidden\" name=\"tag\" value=\"";
  private final static byte[] _jspx_array_25 = _jspx_getBytes(_jspx_array_25S);
  private final static String _jspx_array_26S = "\" id=\"";
  private final static byte[] _jspx_array_26 = _jspx_getBytes(_jspx_array_26S);
  private final static String _jspx_array_27S = "\"/>\r\n                                                </span>\r\n                                        ";
  private final static byte[] _jspx_array_27 = _jspx_getBytes(_jspx_array_27S);
  private final static String _jspx_array_28S = "\r\n\r\n                                </div>\r\n                                <div class=\"footer\">\r\n                                        <input id=\"add\" type=\"submit\" value=\"Add\"/> \r\n                                        <button id=\"cancel\"><a href=\"NovelServlet\" style=\"text-decoration: none;\">Cancel</a></button>\r\n                                </div>\r\n                        </fieldset>\r\n                </form>\r\n                <script defer>\r\n                        const form = document.getElementById(\"form\");\r\n                        const novelName = document.getElementById(\"novelName\");\r\n                        const msg = document.getElementById(\"msg\");\r\n                        const tagName = document.querySelectorAll(\".tagname\");\r\n                        tagName.forEach(button => {\r\n                                button.addEventListener('click', () => {\r\n                                        button.parentNode.classList.toggle(\"selected\");\r\n                                });\r\n                        });\r\n                        form.addEventListener('submit', event => {\r\n                                if (novelName.value === \"\") {\r\n                                        event.preventDefault();\r\n                                        msg.style.visibility = \"visible\";\r\n                                }\r\n                        });\r\n                </script>\r\n        </body>\r\n</html>\r\n";
  private final static byte[] _jspx_array_28 = _jspx_getBytes(_jspx_array_28S);
}
