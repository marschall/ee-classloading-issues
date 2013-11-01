package com.github.marschall.eeclassloadingissues.rarexposure.war;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.marschall.eeclassloadingissues.rarexposure.ejb.LoadingEJb;

public class RarExposureServlet extends HttpServlet {

  @EJB
  private LoadingEJb loadingEjb;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain");
    PrintWriter writer = resp.getWriter();
    if (loadingEjb.isClassAvailable()) {
      writer.print("OK");
    } else {
      writer.print("NOK");
    }
  }

}
