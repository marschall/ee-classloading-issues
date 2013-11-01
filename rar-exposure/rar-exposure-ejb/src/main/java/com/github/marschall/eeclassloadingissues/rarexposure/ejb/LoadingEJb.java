package com.github.marschall.eeclassloadingissues.rarexposure.ejb;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class LoadingEJb {

  public boolean isClassAvailable() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
      Class.forName("LibraryClass", true, classLoader);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }

}
