/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pjsua_call_vid_strm_op {
  public final static pjsua_call_vid_strm_op PJSUA_CALL_VID_STRM_NO_OP = new pjsua_call_vid_strm_op("PJSUA_CALL_VID_STRM_NO_OP");
  public final static pjsua_call_vid_strm_op PJSUA_CALL_VID_STRM_ADD = new pjsua_call_vid_strm_op("PJSUA_CALL_VID_STRM_ADD");
  public final static pjsua_call_vid_strm_op PJSUA_CALL_VID_STRM_REMOVE = new pjsua_call_vid_strm_op("PJSUA_CALL_VID_STRM_REMOVE");
  public final static pjsua_call_vid_strm_op PJSUA_CALL_VID_STRM_CHANGE_DIR = new pjsua_call_vid_strm_op("PJSUA_CALL_VID_STRM_CHANGE_DIR");
  public final static pjsua_call_vid_strm_op PJSUA_CALL_VID_STRM_CHANGE_CAP_DEV = new pjsua_call_vid_strm_op("PJSUA_CALL_VID_STRM_CHANGE_CAP_DEV");
  public final static pjsua_call_vid_strm_op PJSUA_CALL_VID_STRM_START_TRANSMIT = new pjsua_call_vid_strm_op("PJSUA_CALL_VID_STRM_START_TRANSMIT");
  public final static pjsua_call_vid_strm_op PJSUA_CALL_VID_STRM_STOP_TRANSMIT = new pjsua_call_vid_strm_op("PJSUA_CALL_VID_STRM_STOP_TRANSMIT");
  public final static pjsua_call_vid_strm_op PJSUA_CALL_VID_STRM_SEND_KEYFRAME = new pjsua_call_vid_strm_op("PJSUA_CALL_VID_STRM_SEND_KEYFRAME");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pjsua_call_vid_strm_op swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pjsua_call_vid_strm_op.class + " with value " + swigValue);
  }

  private pjsua_call_vid_strm_op(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pjsua_call_vid_strm_op(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pjsua_call_vid_strm_op(String swigName, pjsua_call_vid_strm_op swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pjsua_call_vid_strm_op[] swigValues = { PJSUA_CALL_VID_STRM_NO_OP, PJSUA_CALL_VID_STRM_ADD, PJSUA_CALL_VID_STRM_REMOVE, PJSUA_CALL_VID_STRM_CHANGE_DIR, PJSUA_CALL_VID_STRM_CHANGE_CAP_DEV, PJSUA_CALL_VID_STRM_START_TRANSMIT, PJSUA_CALL_VID_STRM_STOP_TRANSMIT, PJSUA_CALL_VID_STRM_SEND_KEYFRAME };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

