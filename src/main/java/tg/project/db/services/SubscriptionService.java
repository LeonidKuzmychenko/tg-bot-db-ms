package tg.project.db.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tg.project.db.models.Serial;
import tg.project.db.models.User;

@Slf4j
@Service
public class SubscriptionService {

    private final UserService userService;
    private final SerialService serialService;

    public SubscriptionService(UserService userService, SerialService serialService) {
        this.userService = userService;
        this.serialService = serialService;
    }

    public void subscribe(String chatId, String serialId) {
        log.info("subscribe {} to {}", chatId, serialId);
        User user = userService.getAndCheckToExist(chatId);
        Serial serial = serialService.getSerialByApiIdAndCheckForExist(serialId);
        user.getSerials().add(serial);
        serial.getUsers().add(user);
        userService.save(user);
    }

}