package service;

import com.rawtech.io.UsersDatabase;
import com.rawtech.io.UsersDatabaseMapImpl;
import com.rawtech.service.UserService;
import com.rawtech.service.UserServiceImpl;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    UsersDatabase usersDatabase;
    UserService userService;
    String createdUserId = "";

    @BeforeAll
    void setup() {
        // Create & initialize database
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();

        userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
//        Arrange
        Map<String, String> user = new HashMap<>();

//        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Robbie");
        user.put("lastName", "Corcoran");

//        Act
        createdUserId = userService.createUser(user);

//        Assert
        assertNotNull(createdUserId, "User id should be not null");
    }


    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {
//        Arrange
        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("firstName", "Jack");
        newUserDetails.put("lastName", "Jones");

//        Act
        Map updatedUserDetails = userService.updateUser(createdUserId , newUserDetails);

//        Assert
        assertEquals(newUserDetails.get("firstName"), updatedUserDetails.get("firstName"), "Returned values of user's first name is incorrect.");
        assertEquals(newUserDetails.get("lastName"), updatedUserDetails.get("lastName"), "Returned values of user's last name is incorrect.");

    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {
//        Act
        Map userDetails = userService.getUserDetails(createdUserId);

//        Assert
        assertNotNull(userDetails, "Returned user details should be not null");
        assertEquals(createdUserId, userDetails.get("userId"), "Returned user details contains incorrect user id");
    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {
//        Act
        userService.deleteUser(createdUserId);

//        Arrange
        assertNull(userService.getUserDetails(createdUserId), "User should not have been found");
    }

}
