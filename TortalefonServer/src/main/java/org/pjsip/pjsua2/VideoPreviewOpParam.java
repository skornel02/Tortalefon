/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class VideoPreviewOpParam {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected VideoPreviewOpParam(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(VideoPreviewOpParam obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_VideoPreviewOpParam(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRendId(int value) {
    pjsua2JNI.VideoPreviewOpParam_rendId_set(swigCPtr, this, value);
  }

  public int getRendId() {
    return pjsua2JNI.VideoPreviewOpParam_rendId_get(swigCPtr, this);
  }

  public void setShow(boolean value) {
    pjsua2JNI.VideoPreviewOpParam_show_set(swigCPtr, this, value);
  }

  public boolean getShow() {
    return pjsua2JNI.VideoPreviewOpParam_show_get(swigCPtr, this);
  }

  public void setWindowFlags(long value) {
    pjsua2JNI.VideoPreviewOpParam_windowFlags_set(swigCPtr, this, value);
  }

  public long getWindowFlags() {
    return pjsua2JNI.VideoPreviewOpParam_windowFlags_get(swigCPtr, this);
  }

  public void setFormat(MediaFormat value) {
    pjsua2JNI.VideoPreviewOpParam_format_set(swigCPtr, this, MediaFormat.getCPtr(value), value);
  }

  public MediaFormat getFormat() {
    long cPtr = pjsua2JNI.VideoPreviewOpParam_format_get(swigCPtr, this);
    return (cPtr == 0) ? null : new MediaFormat(cPtr, false);
  }

  public void setWindow(VideoWindowHandle value) {
    pjsua2JNI.VideoPreviewOpParam_window_set(swigCPtr, this, VideoWindowHandle.getCPtr(value), value);
  }

  public VideoWindowHandle getWindow() {
    long cPtr = pjsua2JNI.VideoPreviewOpParam_window_get(swigCPtr, this);
    return (cPtr == 0) ? null : new VideoWindowHandle(cPtr, false);
  }

  public VideoPreviewOpParam() {
    this(pjsua2JNI.new_VideoPreviewOpParam(), true);
  }

}
