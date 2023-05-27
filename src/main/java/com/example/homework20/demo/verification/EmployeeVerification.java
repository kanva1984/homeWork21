package com.example.homework20.demo.verification;

import org.apache.commons.lang3.StringUtils;

public class EmployeeVerification {
    public static boolean verification(String firstName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }
}
