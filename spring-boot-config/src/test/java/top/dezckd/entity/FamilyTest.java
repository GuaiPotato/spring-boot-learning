package top.dezckd.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DEZ
 * @DATE 2024/3/11
 */
@SpringBootTest
class FamilyTest {
    @Resource
    private Family family;

    @Test
    public void testFamily(){
        System.out.println(family);
    }
}