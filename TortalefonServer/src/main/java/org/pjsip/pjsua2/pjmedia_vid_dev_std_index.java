/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pjmedia_vid_dev_std_index {
  public final static pjmedia_vid_dev_std_index PJMEDIA_VID_DEFAULT_CAPTURE_DEV = new pjmedia_vid_dev_std_index("PJMEDIA_VID_DEFAULT_CAPTURE_DEV", pjsua2JNI.PJMEDIA_VID_DEFAULT_CAPTURE_DEV_get());
  public final static pjmedia_vid_dev_std_index PJMEDIA_VID_DEFAULT_RENDER_DEV = new pjmedia_vid_dev_std_index("PJMEDIA_VID_DEFAULT_RENDER_DEV", pjsua2JNI.PJMEDIA_VID_DEFAULT_RENDER_DEV_get());
  public final static pjmedia_vid_dev_std_index PJMEDIA_VID_INVALID_DEV = new pjmedia_vid_dev_std_index("PJMEDIA_VID_INVALID_DEV", pjsua2JNI.PJMEDIA_VID_INVALID_DEV_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pjmedia_vid_dev_std_index swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pjmedia_vid_dev_std_index.class + " with value " + swigValue);
  }

  private pjmedia_vid_dev_std_index(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pjmedia_vid_dev_std_index(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pjmedia_vid_dev_std_index(String swigName, pjmedia_vid_dev_std_index swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pjmedia_vid_dev_std_index[] swigValues = { PJMEDIA_VID_DEFAULT_CAPTURE_DEV, PJMEDIA_VID_DEFAULT_RENDER_DEV, PJMEDIA_VID_INVALID_DEV };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

