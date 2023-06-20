package com.targetindia.tests;

import org.junit.jupiter.api.*;

class LifecycleHooksDemo {

    // declare a DB Connection variable here

    @BeforeEach
    void beforeEach() {
        // initialize the DB connection variable here
        System.out.println("LifecycleHooksDemo.beforeEach() called");
    }

    @AfterEach
    void afterEach() {
        // close the DB connection here
        System.out.println("LifecycleHooksDemo.afterEach() called");
    }

    @BeforeAll
    static void beforeAll() {
        // an example use of this would be:
        // create an object of EntityManagerFactory here
        System.out.println("LifecycleHooksDemo.beforeAll() called");
    }

    @AfterAll
    static void afterAll() {
        // close the object of EntityManagerFactory here
        System.out.println("LifecycleHooksDemo.afterAll() called");
    }

    @Test
    void test1() {
        System.out.println("LifecycleHooksDemo.test1() called");
        // DB connection can be used here
        // EntityManagerFactory object can be used here
    }

    @Test
    void test2() {
        System.out.println("LifecycleHooksDemo.test2() called");
        // DB connection can be used here
        // EntityManagerFactory object can be used here
    }

    @Test
    void test3() {
        System.out.println("LifecycleHooksDemo.test3() called");
        // DB connection can be used here
        // EntityManagerFactory object can be used here
    }
}
