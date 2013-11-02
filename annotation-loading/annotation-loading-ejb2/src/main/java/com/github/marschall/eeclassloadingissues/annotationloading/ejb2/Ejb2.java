package com.github.marschall.eeclassloadingissues.annotationloading.ejb2;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;


@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class Ejb2 {
  
  public Object[] getAnnotations() {
    return AnnotatedClass.class.getAnnotations();
  }

}
