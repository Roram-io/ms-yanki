package com.nttdata.msyanki.controller;

import com.nttdata.msyanki.model.YankiAccount;
import com.nttdata.msyanki.service.YankiAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/yanki")
public class YankiAccountController {

    @Autowired
    private KafkaTemplate<String, YankiAccount> kafkaTemplate;

    @Autowired
    private YankiAccountService yankiAccountService;

    private static final String TOPIC= "Kafka_Example";

    @PostMapping("/create")
    public Mono<YankiAccount> createYanki(@RequestBody YankiAccount yankiAccount){
        return yankiAccountService.createAccount(yankiAccount);
    }

    @PutMapping("/update")
    public Mono<YankiAccount> updateYanki(@RequestBody YankiAccount yankiAccount){
        return yankiAccountService.updateAccount(yankiAccount);
    }

    @GetMapping("/get/{nationalId}")
    public Mono<YankiAccount> getAccount(@PathVariable("id") String id){
        return yankiAccountService.getAccount(id);
    }

    @PostMapping("/transaction")
    public Flux<YankiAccount> transaction(@RequestParam("origin") String origin,@RequestParam("destiny") String destiny,@RequestParam("amount") double amount){
        return yankiAccountService.transaction(origin,destiny,amount);
    }

    @PostMapping("/singleMove")
    public Mono<YankiAccount> getAccount(@RequestParam("id") String id, @RequestParam("amount") double amount){
        return yankiAccountService.singleMove(id,amount);
    }

}
