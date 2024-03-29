/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class OnSelectAccountParam {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected OnSelectAccountParam(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(OnSelectAccountParam obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_OnSelectAccountParam(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRdata(SipRxData value) {
    pjsua2JNI.OnSelectAccountParam_rdata_set(swigCPtr, this, SipRxData.getCPtr(value), value);
  }

  public SipRxData getRdata() {
    long cPtr = pjsua2JNI.OnSelectAccountParam_rdata_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SipRxData(cPtr, false);
  }

  public void setAccountIndex(int value) {
    pjsua2JNI.OnSelectAccountParam_accountIndex_set(swigCPtr, this, value);
  }

  public int getAccountIndex() {
    return pjsua2JNI.OnSelectAccountParam_accountIndex_get(swigCPtr, this);
  }

  public OnSelectAccountParam() {
    this(pjsua2JNI.new_OnSelectAccountParam(), true);
  }

}
