package com.example.orderswift;

import com.example.orderswift.model.User;
import com.example.orderswift.repository.UserRepository;
import com.example.orderswift.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void getUsers_ReturnsListOfUsers() {
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(new User("4", "Santiago", "Velez"));
        expectedUsers.add(new User("2", "Alex", "Tarazona"));

        Mockito.when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> actualUsers = userService.getUsers();

        assertEquals(expectedUsers.size(), actualUsers.size());
        assertEquals(expectedUsers.get(0).getFirstName(), actualUsers.get(0).getFirstName());
        assertEquals(expectedUsers.get(1).getLastName(), actualUsers.get(1).getLastName());
    }

    @Test
    public void getUser_ReturnsUserById() {
        User expectedUser = new User("2", "Alex", "Tarazona");

        Mockito.when(userRepository.findById(2)).thenReturn(Optional.of(expectedUser));

        Optional<User> actualUser = userService.getUser(2);

        assertTrue(actualUser.isPresent());
        assertEquals(expectedUser.getFirstName(), actualUser.get().getFirstName());
        assertEquals(expectedUser.getLastName(), actualUser.get().getLastName());
    }

    @Test
    public void saveOrUpdate_SavesUserToRepository() {
        User userToSave = new User("1", "Alexander", "Velez");

        userService.saveOrUpdate(userToSave);

        Mockito.verify(userRepository).save(userToSave);
    }

    @Test
    public void delete_DeletesUserFromRepository() {
        int userIdToDelete = 8;

        userService.delete(userIdToDelete);

        Mockito.verify(userRepository).deleteById(userIdToDelete);
    }
}