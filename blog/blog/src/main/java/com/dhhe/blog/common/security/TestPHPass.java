package com.dhhe.blog.common.security;

public class TestPHPass {
    static final String correct = "hdh2415230834H";
    static final String wrong = "test12346";
    static final String realResult = "$P$BuPcKMJ0c1TpSBUzbd.hUJd457Ekxe.";
    static final String hash = "$P$9IQRaTwmfeRo7ud9Fh4E2PdI0S3r.L0";
    static final String correctpl = "ąćęłóńśźż";
    static final String wrongpl = "acelonszz";
    static final String hashpl = "$P$ByXWbzDvVAJ0jxvNp5sv4xYPIRXJJ1.";
    static final PHPass phpass = new PHPass(8);
    static String hashed = phpass.HashPassword(correct);


    public static void main(String args[]) {
        System.out.println(hashed.equals(realResult));
    }

    public final void testCheckPassword_correct() {
        boolean check = phpass.CheckPassword(correct, this.hashed);
    }

    public final void testCheckPassword_wrong() {
        boolean check = phpass.CheckPassword(wrong, this.hashed);
    }

    public final void testCheckPassword_givenhash_correct() {
        boolean check = phpass.CheckPassword(correct, hash);
    }

    public final void testCheckPassword_givenhash_wrong() {
        boolean check = phpass.CheckPassword(wrong, hash);
    }

    public final void testCheckPassword_nationalCharacters_correct() {
        boolean check = phpass.CheckPassword(correctpl, hashpl);
    }

    public final void testCheckPassword_nationalCharacters_wrong() {
        boolean check = phpass.CheckPassword(wrongpl, hashpl);
    }

}

