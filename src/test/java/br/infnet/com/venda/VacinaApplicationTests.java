package br.infnet.com.venda;

import info.schnatterer.mobynamesgenerator.MobyNamesGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VacinaApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(MobyNamesGenerator.getRandomName());
    }

}
