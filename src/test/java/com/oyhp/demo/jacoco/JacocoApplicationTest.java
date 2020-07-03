package com.oyhp.demo.jacoco;


import org.junit.jupiter.api.*;

class JacocoApplicationTest {

    JacocoApplicationTest(){
        System.out.println("hello");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Init");
    }

    @AfterEach
    void cleanUp(){
        System.out.println("clear");
    }

    @Test
    void contextLoads() {
        Assertions.assertEquals(2,1+1);
        System.out.println("Run Test");
    }

    @Test
    void test2(){
        Assertions.assertEquals(2,1+1);
    }
}
