package itzbund.demo_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Test
  public void testGetAllUsers() throws Exception {
    mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(0));
  }
  
  @Test
  public void testCreateUser() throws Exception {
    String json = "{\"name\": \"John Doe\"}";
    mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value("John Doe"));
  }
}
