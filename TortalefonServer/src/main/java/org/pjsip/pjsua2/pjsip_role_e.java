/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pjsip_role_e {
  public final static pjsip_role_e PJSIP_ROLE_UAC = new pjsip_role_e("PJSIP_ROLE_UAC");
  public final static pjsip_role_e PJSIP_ROLE_UAS = new pjsip_role_e("PJSIP_ROLE_UAS");
  public final static pjsip_role_e PJSIP_UAC_ROLE = new pjsip_role_e("PJSIP_UAC_ROLE", pjsua2JNI.PJSIP_UAC_ROLE_get());
  public final static pjsip_role_e PJSIP_UAS_ROLE = new pjsip_role_e("PJSIP_UAS_ROLE", pjsua2JNI.PJSIP_UAS_ROLE_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pjsip_role_e swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pjsip_role_e.class + " with value " + swigValue);
  }

  private pjsip_role_e(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pjsip_role_e(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pjsip_role_e(String swigName, pjsip_role_e swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pjsip_role_e[] swigValues = { PJSIP_ROLE_UAC, PJSIP_ROLE_UAS, PJSIP_UAC_ROLE, PJSIP_UAS_ROLE };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

