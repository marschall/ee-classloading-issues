package com.github.marschall.eeclassloadingissues.annotationloading.ejb2;

import com.github.marschall.eeclassloadingissues.annotationloading.lib.Annotation;

@Annotation({AnnoationValue2.class, AnnoationValue2.class})
public class Ejb2 {
  
  public Object[] getAnnotations() {
    return Ejb2.class.getAnnotations();
  }

}
