package tg.project.db.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tg.project.db.dtos.UserUpdateResponse;
import tg.project.db.models.User;
import tg.project.db.services.UserService;

import java.util.Set;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User getAndCheckToExist(@RequestParam("chatId") String chatId) {
        return userService.getAndCheckToExist(chatId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody UserUpdateResponse userUpdateResponse) {
        User user = userService.getAndCheckToExist(userUpdateResponse.getChatId());
        user.setCommand(userUpdateResponse.getCommand());
        return userService.save(user);
    }

    @GetMapping(value = "/getAllWhoSubscribeSerialByApiId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Long> getAllWhoSubscribeSerialByApiId(@RequestParam("apiId") Long apiId) {
        return userService.getAllWhoSubscribeSerialByApiId(apiId);
    }
}