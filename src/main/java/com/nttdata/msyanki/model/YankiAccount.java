package com.nttdata.msyanki.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "YankiAccount")
public class YankiAccount {
    @Id
    private String id = UUID.randomUUID().toString();

    private String nationalId;
    private String imei;
    private String phone;
    private String email;

    private double amount=0;
    private String accountNumber;
}
