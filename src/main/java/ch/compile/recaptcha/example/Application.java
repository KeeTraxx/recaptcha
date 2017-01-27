package ch.compile.recaptcha.example;

import ch.compile.recaptcha.ReCaptchaVerify;
import ch.compile.recaptcha.model.SiteVerifyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
public class Application {

    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${ch.compile.recaptcha.siteKey}")
    private String siteKey;

    @Value("${ch.compile.recaptcha.secretKey}")
    private String secretKey;

    private List<Message> messages;

    private ReCaptchaVerify reCaptchaVerify;

    @PostConstruct
    private void init() {
        messages = new ArrayList<>();
        reCaptchaVerify = new ReCaptchaVerify(secretKey);
    }

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        model.put("siteKey", siteKey);
        model.put("messages", messages);
        return "index";
    }

    @PostMapping("/postMessage")
    public String post(@ModelAttribute Message message, @RequestParam(name = "g-recaptcha-response") String gRecaptchaResponse, HttpServletRequest request, Map<String, Object> model) throws IOException {
        logger.info("Got message: " + message);
        logger.info("gRecaptchaResponse: " + gRecaptchaResponse);

        SiteVerifyResponse siteVerifyResponse = reCaptchaVerify.verify(gRecaptchaResponse, request.getRemoteAddr());

        logger.info("siteVerifyResponse: " + siteVerifyResponse);

        if (siteVerifyResponse.isSuccess()) {
            if (message.getName() != null && message.getMessage() != null) {
                messages.add(message);
            }
        }

        model.put(siteVerifyResponse.isSuccess() ? "recaptchaSuccess" : "recaptchaError", true);

        return index(model);

    }

}
