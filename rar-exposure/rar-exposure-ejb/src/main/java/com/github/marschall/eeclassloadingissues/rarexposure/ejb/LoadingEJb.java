package com.github.marschall.eeclassloadingissues.rarexposure.ejb;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class LoadingEJb {

  private static final String LIBRARY_CLASS = "com.github.marschall.eeclassloadingissues.rarexposure.lib.LibraryClass";
  
  private static final String RA_CLASS = "com.github.marschall.eeclassloadingissues.rarexposure.ra.ExposureAdapter";

  public boolean isAdapterClassAvailableTccl() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    return isClassVisible(classLoader, RA_CLASS);
  }
  
  public boolean isAdapterClassAvailableThis() {
    ClassLoader classLoader = this.getClass().getClassLoader();
    return isClassVisible(classLoader, RA_CLASS);
  }
  
  public boolean isLibraryClassAvailableTccl() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    return isClassVisible(classLoader, LIBRARY_CLASS);
  }
  
  public boolean isLibraryClassAvailableThis() {
    ClassLoader classLoader = this.getClass().getClassLoader();
    return isClassVisible(classLoader, LIBRARY_CLASS);
  }

  private boolean isClassVisible(ClassLoader classLoader, String className) {
    try {
      classLoader.loadClass(className);
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }

}
