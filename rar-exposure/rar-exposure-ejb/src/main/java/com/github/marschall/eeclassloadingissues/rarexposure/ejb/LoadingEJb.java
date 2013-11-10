package com.github.marschall.eeclassloadingissues.rarexposure.ejb;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class LoadingEJb {

  public boolean isClassAvailableTccl() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    return isClassVisible(classLoader);
  }
  
  public boolean isClassAvailableThis() {
    ClassLoader classLoader = this.getClass().getClassLoader();
    return isClassVisible(classLoader);
  }

  private boolean isClassVisible(ClassLoader classLoader) {
    try {
      Class.forName("com.github.marschall.eeclassloadingissues.rarexposure.lib.LibraryClass", true, classLoader);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }

}
