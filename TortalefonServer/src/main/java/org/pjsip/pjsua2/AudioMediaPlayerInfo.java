/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class AudioMediaPlayerInfo {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected AudioMediaPlayerInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AudioMediaPlayerInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_AudioMediaPlayerInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setFormatId(pjmedia_format_id value) {
    pjsua2JNI.AudioMediaPlayerInfo_formatId_set(swigCPtr, this, value.swigValue());
  }

  public pjmedia_format_id getFormatId() {
    return pjmedia_format_id.swigToEnum(pjsua2JNI.AudioMediaPlayerInfo_formatId_get(swigCPtr, this));
  }

  public void setPayloadBitsPerSample(long value) {
    pjsua2JNI.AudioMediaPlayerInfo_payloadBitsPerSample_set(swigCPtr, this, value);
  }

  public long getPayloadBitsPerSample() {
    return pjsua2JNI.AudioMediaPlayerInfo_payloadBitsPerSample_get(swigCPtr, this);
  }

  public void setSizeBytes(long value) {
    pjsua2JNI.AudioMediaPlayerInfo_sizeBytes_set(swigCPtr, this, value);
  }

  public long getSizeBytes() {
    return pjsua2JNI.AudioMediaPlayerInfo_sizeBytes_get(swigCPtr, this);
  }

  public void setSizeSamples(long value) {
    pjsua2JNI.AudioMediaPlayerInfo_sizeSamples_set(swigCPtr, this, value);
  }

  public long getSizeSamples() {
    return pjsua2JNI.AudioMediaPlayerInfo_sizeSamples_get(swigCPtr, this);
  }

  public AudioMediaPlayerInfo() {
    this(pjsua2JNI.new_AudioMediaPlayerInfo(), true);
  }

}
