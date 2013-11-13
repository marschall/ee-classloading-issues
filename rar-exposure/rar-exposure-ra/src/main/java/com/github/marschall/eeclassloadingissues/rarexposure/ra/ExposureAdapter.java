package com.github.marschall.eeclassloadingissues.rarexposure.ra;

import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

@Connector
public class ExposureAdapter implements ResourceAdapter {
  
  private static final Logger LOG = Logger.getLogger(ExposureAdapter.class.getName());

  private static final String NAME = "java:global/some/name";
  private InitialContext context;

  @Override
  public void start(BootstrapContext ctx) throws ResourceAdapterInternalException {
    this.logLibraryClassAvailable();
    try {
      context = new InitialContext();
      context.bind(NAME, "aString");
    } catch (NamingException e) {
      throw new ResourceAdapterInternalException("could not bind to: " + NAME, e);
    }
  }

  @Override
  public void stop() {
    this.logLibraryClassAvailable();
    try {
      this.context.unbind(NAME);
      this.context.close();
    } catch (NamingException e) {
      throw new RuntimeException("could not unbind:" + NAME, e);
    }
  }
  
  private void logLibraryClassAvailable() {
    if (this.isLibraryClassAvailable()) {
      LOG.info("library class availble");
    } else {
      LOG.info("library class not availble");
    }
  }

  private boolean isLibraryClassAvailable() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
      classLoader.loadClass("com.github.marschall.eeclassloadingissues.rarexposure.lib.LibraryClass");
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
  
  @Override
  public void endpointActivation(MessageEndpointFactory endpointFactory, ActivationSpec spec) {
  }

  @Override
  public void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec spec) {
  }

  @Override
  public XAResource[] getXAResources(ActivationSpec[] specs) {
    return null;
  }
  
  @Override
  public boolean equals(Object obj) {
    return this == obj;
  }
  
  @Override
  public int hashCode() {
    return System.identityHashCode(this);
  }

}
