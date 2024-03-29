/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class PendingJob {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected PendingJob(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PendingJob obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_PendingJob(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void execute(boolean is_pending) {
    pjsua2JNI.PendingJob_execute(swigCPtr, this, is_pending);
  }

}
