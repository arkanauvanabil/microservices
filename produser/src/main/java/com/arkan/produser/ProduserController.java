package  com.arkan.produser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class ProduserController {

    @RestController
    public class ProsedureController{
        @Autowired
        private ProduserService ProduserService;

        @GetMapping("/send")

        public String snedMessage(@RequestParam String message){
            ProduserService.sendMessage(message);
            return "Message sent: " + message;
        }

    }

}
