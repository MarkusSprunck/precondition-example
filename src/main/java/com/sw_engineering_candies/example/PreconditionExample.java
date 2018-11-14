package com.sw_engineering_candies.example;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.Validate;
import org.springframework.util.Assert;

public class PreconditionExample {

    public static void fooPlainJavaValidation(String name,
                                              int start, int end) {

        // Preconditions
        if (null == name) {
            throw new NullPointerException("Name must not be null");
        }
        if (start >= end) {
            throw new IllegalArgumentException(
                    "Start (" + start + ") must be " +
                            "smaller than end (" + end + ")");
        }
        // Do something here ...
    }

    public static void fooSpringFrameworkAssert(
            String name, int start, int end) {

        // Preconditions
        Assert.notNull(name, "Name must not be null");
        Assert.isTrue(start < end,
                "Start (" + start + ") must be " +
                        "smaller than end (" + end + ")");

        // Do something here ...
    }

    public static void fooApacheCommonsValidate(
            String name, int start, int end) {

        // Preconditions
        Validate.notNull(name, "Name must not be null");
        Validate.isTrue(start < end,
                "Start (%s) must be  " +
                        "smaller than end (%s)", start, end);

        // Do something here ...
    }

    public static void fooGuavaPreconditions(
            String name, int start, int end) {

        // Preconditions
        Preconditions.checkNotNull(name, "Name must not be null");
        Preconditions.checkArgument(start < end,
                "Start (%s) must be " +
                        "smaller than end (%s)", start, end);

        // Do something here ...
    }

    public static void fooPlainJavaAsserts(
            String name, int start, int end) {

        // Preconditions
        assert null != name : "Name must not be null";
        assert start < end :
                "Start (" + start + ") must be " +
                        "smaller than end (" + end + ")";

        // Do something here ...
    }

    public static void main(String[] args) {

        // Case 1: fooPlainJavaValidation
        System.out.println(
                "\n==== Case 1: Plain Java Validation " +
                        "==========================");
        PreconditionExample.fooPlainJavaValidation(
                "abc", 2, 10);
        try {
            PreconditionExample.fooPlainJavaValidation(
                    "abc", 12, 10);
        } catch (final RuntimeException ex) {
            System.out.println(
                    "fooPlainJavaValidation(\"abc\", 12, 10)\n\t"
                            + ex);
        }
        try {
            PreconditionExample.fooPlainJavaValidation(
                    null, 2, 10);
        } catch (final RuntimeException ex) {
            System.out.println(
                    "fooPlainJavaValidation(null, 2, 10)\n\t"
                            + ex);
        }

        // Case 2: fooSpringFrameworkAssert
        System.out.println(
                "\n==== Case 2: Spring Framework Assert " +
                        "========================");
        PreconditionExample.fooSpringFrameworkAssert(
                "abc", 2, 10);
        try {
            PreconditionExample.fooSpringFrameworkAssert(
                    "abc", 12, 10);
        } catch (final RuntimeException ex) {
            System.out.println(
                    "fooSpringFrameworkAssert(\"abc\", 12, 10)\n\t"
                            + ex);
        }
        try {
            PreconditionExample.fooSpringFrameworkAssert(
                    null, 2, 10);
        } catch (final RuntimeException ex) {
            System.out.println(
                    "fooSpringFrameworkAssert(null, 2, 10)\n\t"
                            + ex);
        }

        // Case 3: fooApacheCommonsValidate
        System.out.println(
                "\n==== Case 3: Apache Commons Validate " +
                        "========================");
        PreconditionExample.fooApacheCommonsValidate(
                "abc", 2, 10);
        try {
            PreconditionExample.fooApacheCommonsValidate(
                    "abc", 12, 10);
        } catch (final RuntimeException ex) {
            System.out.println(
                    "fooApacheCommonsValidate(\"abc\", 12, 10)\n\t"
                            + ex);
        }
        try {
            PreconditionExample.fooApacheCommonsValidate(
                    null, 2, 10);
        } catch (final RuntimeException ex) {
            System.out.println(
                    "fooApacheCommonsValidate(null, 2, 10)\n\t"
                            + ex);
        }

        // Case 4: fooGuavaPreconditions
        System.out.println(
                "\n==== Case 4: Guava Preconditions " +
                        "============================");
        PreconditionExample.fooGuavaPreconditions(
                "abc", 2, 10);
        try {
            PreconditionExample.fooGuavaPreconditions(
                    "abc", 12, 10);
        } catch (final RuntimeException ex) {
            System.out.println(
                    "fooGuavaPreconditions(\"abc\", 12, 10)\n\t"
                            + ex);
        }
        try {
            PreconditionExample.fooGuavaPreconditions(null, 2, 10);
        } catch (final RuntimeException ex) {
            System.out.println(
                    "fooGuavaPreconditions(null, 2, 10)\n\t"
                            + ex);
        }

        // Case 5: fooGuavaPreconditions
        System.out.println(
                "\n==== Case 5: Plain Java Asserts " +
                        "=============================");
        PreconditionExample.fooPlainJavaAsserts(
                "abc", 2, 10);
        try {
            PreconditionExample.fooPlainJavaAsserts(
                    "abc", 12, 10);
        } catch (final AssertionError ex) {
            System.out.println(
                    "fooPlainJavaAsserts(\"abc\", 12, 10)\n\t"
                            + ex);
        }
        try {
            PreconditionExample.fooPlainJavaAsserts(null, 2, 10);
        } catch (final AssertionError ex) {
            System.out.println(
                    "fooPlainJavaAsserts(null, 2, 10)\n\t"
                            + ex);
        }
    }
}