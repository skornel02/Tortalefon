/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class MathStat {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected MathStat(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MathStat obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_MathStat(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setN(int value) {
    pjsua2JNI.MathStat_n_set(swigCPtr, this, value);
  }

  public int getN() {
    return pjsua2JNI.MathStat_n_get(swigCPtr, this);
  }

  public void setMax(int value) {
    pjsua2JNI.MathStat_max_set(swigCPtr, this, value);
  }

  public int getMax() {
    return pjsua2JNI.MathStat_max_get(swigCPtr, this);
  }

  public void setMin(int value) {
    pjsua2JNI.MathStat_min_set(swigCPtr, this, value);
  }

  public int getMin() {
    return pjsua2JNI.MathStat_min_get(swigCPtr, this);
  }

  public void setLast(int value) {
    pjsua2JNI.MathStat_last_set(swigCPtr, this, value);
  }

  public int getLast() {
    return pjsua2JNI.MathStat_last_get(swigCPtr, this);
  }

  public void setMean(int value) {
    pjsua2JNI.MathStat_mean_set(swigCPtr, this, value);
  }

  public int getMean() {
    return pjsua2JNI.MathStat_mean_get(swigCPtr, this);
  }

  public MathStat() {
    this(pjsua2JNI.new_MathStat(), true);
  }

}
