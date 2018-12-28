/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class OnMwiInfoParam {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected OnMwiInfoParam(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(OnMwiInfoParam obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_OnMwiInfoParam(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setState(pjsip_evsub_state value) {
    pjsua2JNI.OnMwiInfoParam_state_set(swigCPtr, this, value.swigValue());
  }

  public pjsip_evsub_state getState() {
    return pjsip_evsub_state.swigToEnum(pjsua2JNI.OnMwiInfoParam_state_get(swigCPtr, this));
  }

  public void setRdata(SipRxData value) {
    pjsua2JNI.OnMwiInfoParam_rdata_set(swigCPtr, this, SipRxData.getCPtr(value), value);
  }

  public SipRxData getRdata() {
    long cPtr = pjsua2JNI.OnMwiInfoParam_rdata_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SipRxData(cPtr, false);
  }

  public OnMwiInfoParam() {
    this(pjsua2JNI.new_OnMwiInfoParam(), true);
  }

}
