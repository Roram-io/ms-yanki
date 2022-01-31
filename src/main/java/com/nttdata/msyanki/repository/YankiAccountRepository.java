package com.nttdata.msyanki.repository;

import com.nttdata.msyanki.model.YankiAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface YankiAccountRepository extends ReactiveMongoRepository<YankiAccount,String> {

    Mono<YankiAccount> findYankiAccountByNationalId(String phone);
    Mono<Void>  deleteByNationalId(String phone);

}
