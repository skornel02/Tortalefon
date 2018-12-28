/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class AudioDevInfo {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected AudioDevInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AudioDevInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_AudioDevInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setName(String value) {
    pjsua2JNI.AudioDevInfo_name_set(swigCPtr, this, value);
  }

  public String getName() {
    return pjsua2JNI.AudioDevInfo_name_get(swigCPtr, this);
  }

  public void setInputCount(long value) {
    pjsua2JNI.AudioDevInfo_inputCount_set(swigCPtr, this, value);
  }

  public long getInputCount() {
    return pjsua2JNI.AudioDevInfo_inputCount_get(swigCPtr, this);
  }

  public void setOutputCount(long value) {
    pjsua2JNI.AudioDevInfo_outputCount_set(swigCPtr, this, value);
  }

  public long getOutputCount() {
    return pjsua2JNI.AudioDevInfo_outputCount_get(swigCPtr, this);
  }

  public void setDefaultSamplesPerSec(long value) {
    pjsua2JNI.AudioDevInfo_defaultSamplesPerSec_set(swigCPtr, this, value);
  }

  public long getDefaultSamplesPerSec() {
    return pjsua2JNI.AudioDevInfo_defaultSamplesPerSec_get(swigCPtr, this);
  }

  public void setDriver(String value) {
    pjsua2JNI.AudioDevInfo_driver_set(swigCPtr, this, value);
  }

  public String getDriver() {
    return pjsua2JNI.AudioDevInfo_driver_get(swigCPtr, this);
  }

  public void setCaps(long value) {
    pjsua2JNI.AudioDevInfo_caps_set(swigCPtr, this, value);
  }

  public long getCaps() {
    return pjsua2JNI.AudioDevInfo_caps_get(swigCPtr, this);
  }

  public void setRoutes(long value) {
    pjsua2JNI.AudioDevInfo_routes_set(swigCPtr, this, value);
  }

  public long getRoutes() {
    return pjsua2JNI.AudioDevInfo_routes_get(swigCPtr, this);
  }

  public void setExtFmt(SWIGTYPE_p_std__vectorT_pj__MediaFormat_t value) {
    pjsua2JNI.AudioDevInfo_extFmt_set(swigCPtr, this, SWIGTYPE_p_std__vectorT_pj__MediaFormat_t.getCPtr(value));
  }

  public SWIGTYPE_p_std__vectorT_pj__MediaFormat_t getExtFmt() {
    long cPtr = pjsua2JNI.AudioDevInfo_extFmt_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_std__vectorT_pj__MediaFormat_t(cPtr, false);
  }

  public AudioDevInfo() {
    this(pjsua2JNI.new_AudioDevInfo(), true);
  }

}
