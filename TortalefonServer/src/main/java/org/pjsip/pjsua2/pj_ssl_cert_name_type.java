/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.pjsip.pjsua2;

public final class pj_ssl_cert_name_type {
  public final static pj_ssl_cert_name_type PJ_SSL_CERT_NAME_UNKNOWN = new pj_ssl_cert_name_type("PJ_SSL_CERT_NAME_UNKNOWN", pjsua2JNI.PJ_SSL_CERT_NAME_UNKNOWN_get());
  public final static pj_ssl_cert_name_type PJ_SSL_CERT_NAME_RFC822 = new pj_ssl_cert_name_type("PJ_SSL_CERT_NAME_RFC822");
  public final static pj_ssl_cert_name_type PJ_SSL_CERT_NAME_DNS = new pj_ssl_cert_name_type("PJ_SSL_CERT_NAME_DNS");
  public final static pj_ssl_cert_name_type PJ_SSL_CERT_NAME_URI = new pj_ssl_cert_name_type("PJ_SSL_CERT_NAME_URI");
  public final static pj_ssl_cert_name_type PJ_SSL_CERT_NAME_IP = new pj_ssl_cert_name_type("PJ_SSL_CERT_NAME_IP");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static pj_ssl_cert_name_type swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + pj_ssl_cert_name_type.class + " with value " + swigValue);
  }

  private pj_ssl_cert_name_type(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private pj_ssl_cert_name_type(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private pj_ssl_cert_name_type(String swigName, pj_ssl_cert_name_type swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static pj_ssl_cert_name_type[] swigValues = { PJ_SSL_CERT_NAME_UNKNOWN, PJ_SSL_CERT_NAME_RFC822, PJ_SSL_CERT_NAME_DNS, PJ_SSL_CERT_NAME_URI, PJ_SSL_CERT_NAME_IP };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

