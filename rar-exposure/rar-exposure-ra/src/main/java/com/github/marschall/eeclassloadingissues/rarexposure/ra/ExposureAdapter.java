package com.github.marschall.eeclassloadingissues.rarexposure.ra;

import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

@Connector
public class ExposureAdapter implements ResourceAdapter {

  @Override
  public void start(BootstrapContext ctx) {
  }

  @Override
  public void stop() {
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
