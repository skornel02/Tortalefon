/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class SrtpCrypto {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected SrtpCrypto(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SrtpCrypto obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_SrtpCrypto(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setKey(String value) {
    pjsua2JNI.SrtpCrypto_key_set(swigCPtr, this, value);
  }

  public String getKey() {
    return pjsua2JNI.SrtpCrypto_key_get(swigCPtr, this);
  }

  public void setName(String value) {
    pjsua2JNI.SrtpCrypto_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return pjsua2JNI.SrtpCrypto_name_get(swigCPtr, this);
  }

  public void setFlags(long value) {
    pjsua2JNI.SrtpCrypto_flags_set(swigCPtr, this, value);
  }

  public long getFlags() {
    return pjsua2JNI.SrtpCrypto_flags_get(swigCPtr, this);
  }

  public SrtpCrypto() {
    this(pjsua2JNI.new_SrtpCrypto(), true);
  }

}
