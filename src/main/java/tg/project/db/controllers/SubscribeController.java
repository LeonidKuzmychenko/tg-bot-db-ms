package tg.project.db.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tg.project.db.dtos.SubscribeCreateRequest;
import tg.project.db.services.SubscriptionService;

@RestController
@RequestMapping("/v1/subscriptions")
public class SubscribeController {

    private final SubscriptionService subscriptionService;

    public SubscribeController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void subscribe(@RequestBody SubscribeCreateRequest subscribeCreateRequest) {
        subscriptionService.subscribe(subscribeCreateRequest.getChatId(), subscribeCreateRequest.getApiId());
    }
}