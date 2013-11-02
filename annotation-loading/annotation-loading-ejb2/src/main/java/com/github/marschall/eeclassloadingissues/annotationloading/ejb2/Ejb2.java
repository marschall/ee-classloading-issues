package com.github.marschall.eeclassloadingissues.annotationloading.ejb2;


public class Ejb2 implements IEjb2 {
  
  @Override
  public Object[] getAnnotations() {
    return AnnotatedClass.class.getAnnotations();
  }

}
