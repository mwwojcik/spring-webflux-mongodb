package mw.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.ContentType;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserProfileRepository repo;

    private UserProfileEntry createUserProfileEntry() {
        return new UserProfileEntry(UUID.randomUUID().toString(), "Mariusz", "Wojcik", List.of("mw.wojcik@gmail.com"));
    }

    @BeforeEach
    public void deleteAll() {
        repo.deleteAll();
    }

    @DisplayName("GET on /api/profiles, returns OK")
    @Test
    void findAllUserProfiles()
            throws Exception {
        // when 
        mockMvc.perform(MockMvcRequestBuilders.get("/api/profiles"))
                // then
                .andExpect(status().isOk());

    }

    @DisplayName("POST on /api/profiles, returns created status")
    @Test
    void createUserProfile()
            throws Exception {
        // given
        UserProfileEntry entry = createUserProfileEntry();
        // when 
        mockMvc.perform(MockMvcRequestBuilders.post("/api/profiles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entry)))
                // then
                .andExpect(status().isCreated());
    }

    @DisplayName("GET on /api/profiles/{id},returns single doc ")
    @Test
    void getUserProfileById()
            throws Exception {
        //given
        UserProfileEntry savedProfile = repo.save(createUserProfileEntry());
        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/api/profiles/{id}", savedProfile.getId()))
        // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(savedProfile.getId())));

    }

    @DisplayName("PATCH on /api/profilse/{id},returns OK")
    @Test void test()
     throws Exception {
      // given
        UserProfileEntry user = this.createUserProfileEntry();
        repo.save(user);

        UserProfileEntry newUserProfileEntry = this.createUserProfileEntry();
        newUserProfileEntry.setName("NewName");
        newUserProfileEntry.setLastname("NewLastName");

        // when 
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/profiles/{id}",user.getId())
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(newUserProfileEntry)))
      // then
      .andExpect(status().isOk());

      }

      @DisplayName("DELETE on /api/profiles/{id},returns OK")
      @Test void deleteTest()
       throws Exception {
        // given
          UserProfileEntry userProfileEntry = createUserProfileEntry();
          repo.save(userProfileEntry);
          // when 
          mockMvc.perform(MockMvcRequestBuilders.delete("/api/profiles/{id}",userProfileEntry.getId()))
        // then
          .andExpect(status().isOk());
        }
}