/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class CodecFmtp {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected CodecFmtp(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CodecFmtp obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_CodecFmtp(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(String value) {
    pjsua2JNI.CodecFmtp_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return pjsua2JNI.CodecFmtp_name_get(swigCPtr, this);
  }

  public void setVal(String value) {
    pjsua2JNI.CodecFmtp_val_set(swigCPtr, this, value);
  }

  public String getVal() {
    return pjsua2JNI.CodecFmtp_val_get(swigCPtr, this);
  }

  public CodecFmtp() {
    this(pjsua2JNI.new_CodecFmtp(), true);
  }

}
