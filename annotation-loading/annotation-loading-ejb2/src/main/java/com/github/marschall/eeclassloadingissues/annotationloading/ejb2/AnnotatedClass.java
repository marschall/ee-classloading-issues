package com.github.marschall.eeclassloadingissues.annotationloading.ejb2;

import com.github.marschall.eeclassloadingissues.annotationloading.ejb1.AnnoationValue1;
import com.github.marschall.eeclassloadingissues.annotationloading.lib.Annotation;

@Annotation({AnnoationValue1.class, AnnoationValue2.class})
public class AnnotatedClass {

}
