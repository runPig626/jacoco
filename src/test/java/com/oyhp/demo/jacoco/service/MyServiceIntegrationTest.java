package com.oyhp.demo.jacoco.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.oyhp.demo.jacoco.JacocoApplication;
import com.oyhp.demo.jacoco.model.Category;
import org.apache.http.util.Asserts;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.List;

/**
 * XXXX
 *
 * @author OuYangHaiPing<OuYanghp @ pvc123.com>
 * @date 2020-07-06
 */
@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = JacocoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
class MyServiceIntegrationTest {
    private MockMvc mockMvc;
    @Autowired
    CategoryService categoryService;
    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp(){
        // 初始化内存数据库，以备测试, maven已配置，就不需要java api的了
//        ClassicConfiguration conf = new ClassicConfiguration();
//        conf.setDataSource(
//                "jdbc:h2:mem:test",
//                "test",
//                "test"
//        );
//
//        Flyway flyway = new Flyway(conf);
//        flyway.clean();
//        flyway.migrate();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void fillAllTest(){
        List<Category> categoryList = categoryService.fillAll();
        System.out.println("categoryList = " + categoryList);
    }

    @Test
    void add_test(){
        Category category = new Category();
        category.setName("test");
        categoryService.add(category);
        List<Category> categoryList = categoryService.fillAll();
    }

    @Test
    void do_get_list_test(){
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/category/list"))
                                .andExpect(MockMvcResultMatchers.status().is(200))
                                .andDo(MockMvcResultHandlers.print())
                                .andReturn();
            int status = mvcResult.getResponse().getStatus();
            Assertions.assertEquals(200, status);
            String result = mvcResult.getResponse().getContentAsString();
            JSONArray resultArray = JSON.parseArray(result);
            // 判断接口返回json中success字段是否为true
            Assertions.assertEquals(4, resultArray.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
