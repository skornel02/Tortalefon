/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pj_log_decoration {
  public final static pj_log_decoration PJ_LOG_HAS_DAY_NAME = new pj_log_decoration("PJ_LOG_HAS_DAY_NAME", pjsua2JNI.PJ_LOG_HAS_DAY_NAME_get());
  public final static pj_log_decoration PJ_LOG_HAS_YEAR = new pj_log_decoration("PJ_LOG_HAS_YEAR", pjsua2JNI.PJ_LOG_HAS_YEAR_get());
  public final static pj_log_decoration PJ_LOG_HAS_MONTH = new pj_log_decoration("PJ_LOG_HAS_MONTH", pjsua2JNI.PJ_LOG_HAS_MONTH_get());
  public final static pj_log_decoration PJ_LOG_HAS_DAY_OF_MON = new pj_log_decoration("PJ_LOG_HAS_DAY_OF_MON", pjsua2JNI.PJ_LOG_HAS_DAY_OF_MON_get());
  public final static pj_log_decoration PJ_LOG_HAS_TIME = new pj_log_decoration("PJ_LOG_HAS_TIME", pjsua2JNI.PJ_LOG_HAS_TIME_get());
  public final static pj_log_decoration PJ_LOG_HAS_MICRO_SEC = new pj_log_decoration("PJ_LOG_HAS_MICRO_SEC", pjsua2JNI.PJ_LOG_HAS_MICRO_SEC_get());
  public final static pj_log_decoration PJ_LOG_HAS_SENDER = new pj_log_decoration("PJ_LOG_HAS_SENDER", pjsua2JNI.PJ_LOG_HAS_SENDER_get());
  public final static pj_log_decoration PJ_LOG_HAS_NEWLINE = new pj_log_decoration("PJ_LOG_HAS_NEWLINE", pjsua2JNI.PJ_LOG_HAS_NEWLINE_get());
  public final static pj_log_decoration PJ_LOG_HAS_CR = new pj_log_decoration("PJ_LOG_HAS_CR", pjsua2JNI.PJ_LOG_HAS_CR_get());
  public final static pj_log_decoration PJ_LOG_HAS_SPACE = new pj_log_decoration("PJ_LOG_HAS_SPACE", pjsua2JNI.PJ_LOG_HAS_SPACE_get());
  public final static pj_log_decoration PJ_LOG_HAS_COLOR = new pj_log_decoration("PJ_LOG_HAS_COLOR", pjsua2JNI.PJ_LOG_HAS_COLOR_get());
  public final static pj_log_decoration PJ_LOG_HAS_LEVEL_TEXT = new pj_log_decoration("PJ_LOG_HAS_LEVEL_TEXT", pjsua2JNI.PJ_LOG_HAS_LEVEL_TEXT_get());
  public final static pj_log_decoration PJ_LOG_HAS_THREAD_ID = new pj_log_decoration("PJ_LOG_HAS_THREAD_ID", pjsua2JNI.PJ_LOG_HAS_THREAD_ID_get());
  public final static pj_log_decoration PJ_LOG_HAS_THREAD_SWC = new pj_log_decoration("PJ_LOG_HAS_THREAD_SWC", pjsua2JNI.PJ_LOG_HAS_THREAD_SWC_get());
  public final static pj_log_decoration PJ_LOG_HAS_INDENT = new pj_log_decoration("PJ_LOG_HAS_INDENT", pjsua2JNI.PJ_LOG_HAS_INDENT_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pj_log_decoration swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pj_log_decoration.class + " with value " + swigValue);
  }

  private pj_log_decoration(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pj_log_decoration(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pj_log_decoration(String swigName, pj_log_decoration swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pj_log_decoration[] swigValues = { PJ_LOG_HAS_DAY_NAME, PJ_LOG_HAS_YEAR, PJ_LOG_HAS_MONTH, PJ_LOG_HAS_DAY_OF_MON, PJ_LOG_HAS_TIME, PJ_LOG_HAS_MICRO_SEC, PJ_LOG_HAS_SENDER, PJ_LOG_HAS_NEWLINE, PJ_LOG_HAS_CR, PJ_LOG_HAS_SPACE, PJ_LOG_HAS_COLOR, PJ_LOG_HAS_LEVEL_TEXT, PJ_LOG_HAS_THREAD_ID, PJ_LOG_HAS_THREAD_SWC, PJ_LOG_HAS_INDENT };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

