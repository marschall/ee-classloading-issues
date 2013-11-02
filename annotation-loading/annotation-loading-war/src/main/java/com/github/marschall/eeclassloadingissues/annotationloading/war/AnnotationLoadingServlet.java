package com.github.marschall.eeclassloadingissues.annotationloading.war;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.marschall.eeclassloadingissues.annotationloading.ejb2.IEjb2;

public class AnnotationLoadingServlet extends HttpServlet {
  
  @EJB
  private IEjb2 ejb;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain");
    PrintWriter writer = resp.getWriter();
    for (Object each : ejb.getAnnotations()) {
      writer.println(each);
    }
  }

}
