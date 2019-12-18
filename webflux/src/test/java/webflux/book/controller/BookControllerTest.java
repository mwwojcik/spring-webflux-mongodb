package webflux.book.controller;

import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureWebTestClient
class BookControllerTest {
    @Autowired
    private WebTestClient webTestClient;


    @DisplayName("given GET request, finds all books")
    @Test void shouldReturnBooksCollection()
     throws Exception {
      // given
      // when 
      // then

      Fail.fail("Write your test");

      }

      @DisplayName("given GET request, get book with id")
      @Test void shouldReturnBookWithId() 
       throws Exception {
        // given
        // when 
          
        // then 
        
        Fail.fail("Write your test"); 
        
        }
      @DisplayName("given POST request, should add new book.")
      @Test void shouldAddNewBook()
       throws Exception {
        // given
        // when 
        // then

        Fail.fail("Write your test");

        }

        @DisplayName("given PUT request, should update one record")
        @Test void shouldUpdateOneProperty()
         throws Exception {
          // given
          // when 
          // then

          Fail.fail("Write your test");

          }
          @DisplayName("given PATCH request, should patch given record")
          @Test void test()
           throws Exception {
            // given
            // when 
            // then

            Fail.fail("Write your test");

            }

          @DisplayName("given DELETE request, should delete record")
          @Test void shouldDeleteBook()
           throws Exception {
            // given
            // when 
            // then

            Fail.fail("Write your test");

            }
}