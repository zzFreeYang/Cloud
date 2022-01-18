package zzfree.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demos")
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);


    @GetMapping
    public String demos(){
        log.info("atricles demos");
        return "atricles demos";
    }
}
