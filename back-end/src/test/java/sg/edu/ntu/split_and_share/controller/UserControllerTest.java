package sg.edu.ntu.split_and_share.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
// import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
// https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/

import sg.edu.ntu.split_and_share.entity.User;
// import sg.edu.ntu.split_and_share.repository.UserRepository;
import sg.edu.ntu.split_and_share.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private UserService userService;

	@Autowired
	private ObjectMapper objectMapper;

	// @Mock
	// private UserRepository UserRepository;

	// @Test
	// public void testCreateUser() throws Exception {
	// // POST request to /api/user
	// mockMvc.perform(MockMvcRequestBuilders
	// .post("/api/user")
	// .content(asJsonString(new User(null, "username", "password", "name", null)))
	// .contentType(MediaType.APPLICATION_JSON)
	// .accept(MediaType.APPLICATION_JSON))
	// .andExpect(MockMvcResultMatchers.jsonPath("$.username").exists());
	// }

	// public static String asJsonString(final Object obj) {
	// try {
	// return new ObjectMapper().writeValueAsString(obj);
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }

	@Test
	public void testGetUserById() throws Exception {
		// Arrange
		User user = new User(null, "jane_doe", "password", "Jane Doe", null);
		when(userService.getUser("jane_doe")).thenReturn(user);
		// GET request to /api/user/{username}
		RequestBuilder request = MockMvcRequestBuilders.get("/api/user/jane_doe");
		mockMvc.perform(request)
				// .andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.username").value("jane_doe"));
	}

	// @Test
	// public void testUpdateUser() throws Exception {
	// // Step 1: Build a GET request to /customers/1
	// RequestBuilder request = MockMvcRequestBuilders.get("/users/1");

	// // Step 2: Perform the request, get response and assert
	// mockMvc.perform(request)
	// // Assert that the status code is 200 OK
	// .andExpect(status().isOk())
	// // Assert that the content type is JSON
	// .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	// // Assert that the id returned is 1
	// .andExpect(jsonPath("$.id").value(1));
	// }

	// @Test
	// public void testDeleteUser() throws Exception {
	// // Step 1: Build a GET request to /customers/1
	// RequestBuilder request = MockMvcRequestBuilders.get("/users/1");

	// // Step 2: Perform the request, get response and assert
	// mockMvc.perform(request)
	// // Assert that the status code is 200 OK
	// .andExpect(status().isOk())
	// // Assert that the content type is JSON
	// .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	// // Assert that the id returned is 1
	// .andExpect(jsonPath("$.id").value(1));
	// }

}
