package ch.compile.recaptcha.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class SiteVerifyResponse {

    private boolean success;
    private Date challenge_ts;
    private String hostname;

    @SerializedName("error-codes")
    private List<String> errorCodes;

}
