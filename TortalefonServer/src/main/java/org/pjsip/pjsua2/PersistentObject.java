/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public class PersistentObject {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected PersistentObject(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PersistentObject obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pjsua2JNI.delete_PersistentObject(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void readObject(ContainerNode node) throws java.lang.Exception {
    pjsua2JNI.PersistentObject_readObject(swigCPtr, this, ContainerNode.getCPtr(node), node);
  }

  public void writeObject(ContainerNode node) throws java.lang.Exception {
    pjsua2JNI.PersistentObject_writeObject(swigCPtr, this, ContainerNode.getCPtr(node), node);
  }

}
