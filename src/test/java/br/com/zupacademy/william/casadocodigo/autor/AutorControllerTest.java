package br.com.zupacademy.william.casadocodigo.autor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
class AutorControllerTest {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test() throws Exception {
        AutorInputDto autorInputDto = new AutorInputDto("William",
                "william.almeida@123.com",
                "descrição");

        String json = objectMapper.writeValueAsString(autorInputDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/autores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value("3"))
                .andExpect(MockMvcResultMatchers.jsonPath("descricao").value("descrição"));

        Optional<Autor> possivelAutor = autorRepository.findById(3L);

        Assertions.assertTrue(possivelAutor.isPresent());
        Assertions.assertEquals(possivelAutor.get().getEmail(), "william.almeida@123.com");
    }

}