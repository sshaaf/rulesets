package org.acme.ssti;

import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.StringLookup;

public class SafeInterpolator {
    public static void main(String[] args) {
        StringSubstitutor interpolator = new StringSubstitutor(new NoScriptLookup());
        String out = interpolator.replace("${script:javascript:java.lang.Runtime.getRuntime().exec('touch /tmp/CVE-2022-42889')}");
        System.out.println(out); // Output: "${script:javascript:...}" (not executed)
    }

    static class NoScriptLookup implements StringLookup {
        @Override
        public String lookup(String key) {
            if (key != null && key.startsWith("script:")) {
                return "${" + key + "}";
            }
            return null;
        }
    }
}