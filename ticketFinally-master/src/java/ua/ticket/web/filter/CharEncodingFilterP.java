/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.ticket.web.filter;

/**
 *
 * @author us9546
 */
import javax.servlet.*;
import java.io.IOException;

public class CharEncodingFilterP implements Filter {

private FilterConfig filterConfig = null;

private String encoding = null;

public void init(FilterConfig filterConfig) throws ServletException {
this.filterConfig = filterConfig;
this.encoding = this.filterConfig.getInitParameter("encoding");
}

public void destroy() {
this.filterConfig = null;
}

public void doFilter(ServletRequest request, ServletResponse response,
FilterChain chain) throws IOException, ServletException {
if (encoding != null) {
request.setCharacterEncoding(encoding);
}
chain.doFilter(request, response);
}
}
