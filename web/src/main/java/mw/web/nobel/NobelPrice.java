package mw.web.nobel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mw.web.nobel.Winner;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@AllArgsConstructor
@NoArgsConstructor
class NobelPrice {
    private UUID id;
    private int year;
    private Winner winner;
    private String category;
}
