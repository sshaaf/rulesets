package org.acme.ssti;

public class ScriptSyntaxInCode {
    public static void main(String[] args) {
        String dangerousString = "${script:javascript:alert('SSTI!')}";
        System.out.println(dangerousString);
    }
}
