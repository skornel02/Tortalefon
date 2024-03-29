/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class StreamInfo {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected StreamInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(StreamInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_StreamInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setType(pjmedia_type value) {
    pjsua2JNI.StreamInfo_type_set(swigCPtr, this, value.swigValue());
  }

  public pjmedia_type getType() {
    return pjmedia_type.swigToEnum(pjsua2JNI.StreamInfo_type_get(swigCPtr, this));
  }

  public void setProto(pjmedia_tp_proto value) {
    pjsua2JNI.StreamInfo_proto_set(swigCPtr, this, value.swigValue());
  }

  public pjmedia_tp_proto getProto() {
    return pjmedia_tp_proto.swigToEnum(pjsua2JNI.StreamInfo_proto_get(swigCPtr, this));
  }

  public void setDir(pjmedia_dir value) {
    pjsua2JNI.StreamInfo_dir_set(swigCPtr, this, value.swigValue());
  }

  public pjmedia_dir getDir() {
    return pjmedia_dir.swigToEnum(pjsua2JNI.StreamInfo_dir_get(swigCPtr, this));
  }

  public void setRemoteRtpAddress(String value) {
    pjsua2JNI.StreamInfo_remoteRtpAddress_set(swigCPtr, this, value);
  }

  public String getRemoteRtpAddress() {
    return pjsua2JNI.StreamInfo_remoteRtpAddress_get(swigCPtr, this);
  }

  public void setRemoteRtcpAddress(String value) {
    pjsua2JNI.StreamInfo_remoteRtcpAddress_set(swigCPtr, this, value);
  }

  public String getRemoteRtcpAddress() {
    return pjsua2JNI.StreamInfo_remoteRtcpAddress_get(swigCPtr, this);
  }

  public void setTxPt(long value) {
    pjsua2JNI.StreamInfo_txPt_set(swigCPtr, this, value);
  }

  public long getTxPt() {
    return pjsua2JNI.StreamInfo_txPt_get(swigCPtr, this);
  }

  public void setRxPt(long value) {
    pjsua2JNI.StreamInfo_rxPt_set(swigCPtr, this, value);
  }

  public long getRxPt() {
    return pjsua2JNI.StreamInfo_rxPt_get(swigCPtr, this);
  }

  public void setCodecName(String value) {
    pjsua2JNI.StreamInfo_codecName_set(swigCPtr, this, value);
  }

  public String getCodecName() {
    return pjsua2JNI.StreamInfo_codecName_get(swigCPtr, this);
  }

  public void setCodecClockRate(long value) {
    pjsua2JNI.StreamInfo_codecClockRate_set(swigCPtr, this, value);
  }

  public long getCodecClockRate() {
    return pjsua2JNI.StreamInfo_codecClockRate_get(swigCPtr, this);
  }

  public void setAudCodecParam(CodecParam value) {
    pjsua2JNI.StreamInfo_audCodecParam_set(swigCPtr, this, CodecParam.getCPtr(value), value);
  }

  public CodecParam getAudCodecParam() {
    long cPtr = pjsua2JNI.StreamInfo_audCodecParam_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CodecParam(cPtr, false);
  }

  public void setVidCodecParam(VidCodecParam value) {
    pjsua2JNI.StreamInfo_vidCodecParam_set(swigCPtr, this, VidCodecParam.getCPtr(value), value);
  }

  public VidCodecParam getVidCodecParam() {
    long cPtr = pjsua2JNI.StreamInfo_vidCodecParam_get(swigCPtr, this);
    return (cPtr == 0) ? null : new VidCodecParam(cPtr, false);
  }

  public StreamInfo() {
    this(pjsua2JNI.new_StreamInfo(), true);
  }

}
