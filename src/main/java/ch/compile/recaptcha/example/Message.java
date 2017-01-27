package ch.compile.recaptcha.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {
    private String name;
    private String message;
}
