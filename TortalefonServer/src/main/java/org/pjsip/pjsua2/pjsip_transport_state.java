/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pjsip_transport_state {
  public final static pjsip_transport_state PJSIP_TP_STATE_CONNECTED = new pjsip_transport_state("PJSIP_TP_STATE_CONNECTED");
  public final static pjsip_transport_state PJSIP_TP_STATE_DISCONNECTED = new pjsip_transport_state("PJSIP_TP_STATE_DISCONNECTED");
  public final static pjsip_transport_state PJSIP_TP_STATE_SHUTDOWN = new pjsip_transport_state("PJSIP_TP_STATE_SHUTDOWN");
  public final static pjsip_transport_state PJSIP_TP_STATE_DESTROY = new pjsip_transport_state("PJSIP_TP_STATE_DESTROY");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pjsip_transport_state swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pjsip_transport_state.class + " with value " + swigValue);
  }

  private pjsip_transport_state(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pjsip_transport_state(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pjsip_transport_state(String swigName, pjsip_transport_state swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pjsip_transport_state[] swigValues = { PJSIP_TP_STATE_CONNECTED, PJSIP_TP_STATE_DISCONNECTED, PJSIP_TP_STATE_SHUTDOWN, PJSIP_TP_STATE_DESTROY };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

