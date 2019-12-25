package mw.web.nobel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/winners")
class NobelPriceWinnerController {
    private NobelPriceWinnerService service;

    NobelPriceWinnerController(NobelPriceWinnerService service) {
        this.service = service;
    }

}
