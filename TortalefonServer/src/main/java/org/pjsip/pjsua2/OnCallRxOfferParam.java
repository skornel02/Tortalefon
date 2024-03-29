/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class OnCallRxOfferParam {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected OnCallRxOfferParam(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(OnCallRxOfferParam obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_OnCallRxOfferParam(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setOffer(SdpSession value) {
    pjsua2JNI.OnCallRxOfferParam_offer_set(swigCPtr, this, SdpSession.getCPtr(value), value);
  }

  public SdpSession getOffer() {
    long cPtr = pjsua2JNI.OnCallRxOfferParam_offer_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SdpSession(cPtr, false);
  }

  public void setStatusCode(pjsip_status_code value) {
    pjsua2JNI.OnCallRxOfferParam_statusCode_set(swigCPtr, this, value.swigValue());
  }

  public pjsip_status_code getStatusCode() {
    return pjsip_status_code.swigToEnum(pjsua2JNI.OnCallRxOfferParam_statusCode_get(swigCPtr, this));
  }

  public void setOpt(CallSetting value) {
    pjsua2JNI.OnCallRxOfferParam_opt_set(swigCPtr, this, CallSetting.getCPtr(value), value);
  }

  public CallSetting getOpt() {
    long cPtr = pjsua2JNI.OnCallRxOfferParam_opt_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CallSetting(cPtr, false);
  }

  public OnCallRxOfferParam() {
    this(pjsua2JNI.new_OnCallRxOfferParam(), true);
  }

}
