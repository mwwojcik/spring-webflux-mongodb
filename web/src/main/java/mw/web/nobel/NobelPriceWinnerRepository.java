package mw.web.nobel;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

interface NobelPriceWinnerRepository  extends MongoRepository<NobelPrice, UUID> {
}
