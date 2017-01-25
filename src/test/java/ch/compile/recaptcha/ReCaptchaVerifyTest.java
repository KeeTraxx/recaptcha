package ch.compile.recaptcha;


import ch.compile.recaptcha.model.SiteVerifyResponse;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class ReCaptchaVerifyTest {

    @Test
    public void successTest() throws IOException {
        // ReCaptcha Secret Key for testing purposes.
        // See: https://developers.google.com/recaptcha/docs/faq
        ReCaptchaVerify reCaptchaVerify = new ReCaptchaVerify("6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe");
        SiteVerifyResponse siteVerifyResponse = reCaptchaVerify.verify("03AHJ_VutQvYt9miWN6T9VVqqElT6CPFpI8vJFUqI5Kv3GMVhbGex947-G74I1VM15K0Sd6DmgTdrUQ-J0_6UjWoQHtUhqWFaCNdbjIrF5xFCQlZSsnkRB60tb_UP6-EXSxmon4Shx6oK5PgrfE4g9Xc1sGWC2utfurzJ4lX2gXyiAKT1nt1ulbfxlW91x45nYk5ODrpaDX6vexx1lR0nrNVBgrQee5BgCRL3nRgVeMLq5xhr_2eWgKMaYyI-yVAZSd5dw3fHX9UVLpoo-6qekkRL64aP_KrSy2CBlAM1OnpdhpmPzKwcdiX1VYFl8mFBaMKJVZ84cwrrrHgD0nZynhspQDCcVmoSgdhS8JfuNBaxJ3BCy2GPEVZ8Cj4Zg5f82oQvoCwGKAEZ3R8gIjBDLGWoGqxRYGfvv5nENj3hQjwnwNZLF9LATXoz-JIbzIQmOu-HorcPE1tbv2j36BS183OrKLKMZ09dcMuKDf_gzmX68GPk6lM1W8c4KdGBenfCzdkcMmbARxpzKq5oUZuPipWFQWlbKVfcEJ8rmoMHJRMbPjNv43u0oaLVIvIvddwXHDZsp_NuN5OBYqMj7rIg3Cm0PY8Mt7dEYI1bHX_HZ2vvwD8tjd8kYR8hpFFfxTyDPjbn76fcjtl7BB-cy9he34REveizaozkFquhhu1YK1mNnjgqV_epyktJJEaLTB4VIX4u4uavNVNy3WOWQBruCkbkYABzINexiL4rRxKMtQRf1VXjkwBbmcq9eVCdj8PIVMKAEAUCmOJJxiGmJa4BARMY-lJW5GfwQPFCeeedKR0WX5Uzsa3kwQGOIA9E83gqFBz7haId8-qL5gZcbxBo7CHnhJ7CbtASmLMpz0i9bwZsPjvA8uvFCYLvW0aE--ymRJrGhgRtAt694rIJmh8nGDZ_KysuiA2IjBIyZ2I6Rq_00p9MK-pXKq6SWUKvE2Z1TCJC7-qaM8zdjSdQ8HmpTP6YryXCy7OH5BQSZ2GZtrv6uAvaQDvKp5DtpLwhTwXcBJ6GV6TnBZkF8u6hytIRSi-7lV2Uh2avOBtZZHIcFCZP5CUtHxtPD3PKvjB3l2lu_Vws2W2ImCDzFcXL-TvNaW4PxHV29vYSksioL1FqEssUUzOJXcJIuWrydpZ6FeZKE4SWlOZSBPXREkaYuhw5sY8X9dXqbZ2xTsw", "127.0.0.1");
        assertThat(siteVerifyResponse.isSuccess()).isTrue();
        assertThat(siteVerifyResponse.getChallenge_ts()).isNotNull();
        assertThat(siteVerifyResponse.getHostname()).isEqualTo("www.google.com");

        assertThat(siteVerifyResponse.getErrorCodes()).isNull();
    }


    @Test
    public void wrongSiteSecretTest() throws IOException {
        // ReCaptcha Secret Key for testing purposes.
        // See: https://developers.google.com/recaptcha/docs/faq
        ReCaptchaVerify reCaptchaVerify = new ReCaptchaVerify("test");
        SiteVerifyResponse siteVerifyResponse = reCaptchaVerify.verify("03AHJ_VutQvYt9miWN6T9VVqqElT6CPFpI8vJFUqI5Kv3GMVhbGex947-G74I1VM15K0Sd6DmgTdrUQ-J0_6UjWoQHtUhqWFaCNdbjIrF5xFCQlZSsnkRB60tb_UP6-EXSxmon4Shx6oK5PgrfE4g9Xc1sGWC2utfurzJ4lX2gXyiAKT1nt1ulbfxlW91x45nYk5ODrpaDX6vexx1lR0nrNVBgrQee5BgCRL3nRgVeMLq5xhr_2eWgKMaYyI-yVAZSd5dw3fHX9UVLpoo-6qekkRL64aP_KrSy2CBlAM1OnpdhpmPzKwcdiX1VYFl8mFBaMKJVZ84cwrrrHgD0nZynhspQDCcVmoSgdhS8JfuNBaxJ3BCy2GPEVZ8Cj4Zg5f82oQvoCwGKAEZ3R8gIjBDLGWoGqxRYGfvv5nENj3hQjwnwNZLF9LATXoz-JIbzIQmOu-HorcPE1tbv2j36BS183OrKLKMZ09dcMuKDf_gzmX68GPk6lM1W8c4KdGBenfCzdkcMmbARxpzKq5oUZuPipWFQWlbKVfcEJ8rmoMHJRMbPjNv43u0oaLVIvIvddwXHDZsp_NuN5OBYqMj7rIg3Cm0PY8Mt7dEYI1bHX_HZ2vvwD8tjd8kYR8hpFFfxTyDPjbn76fcjtl7BB-cy9he34REveizaozkFquhhu1YK1mNnjgqV_epyktJJEaLTB4VIX4u4uavNVNy3WOWQBruCkbkYABzINexiL4rRxKMtQRf1VXjkwBbmcq9eVCdj8PIVMKAEAUCmOJJxiGmJa4BARMY-lJW5GfwQPFCeeedKR0WX5Uzsa3kwQGOIA9E83gqFBz7haId8-qL5gZcbxBo7CHnhJ7CbtASmLMpz0i9bwZsPjvA8uvFCYLvW0aE--ymRJrGhgRtAt694rIJmh8nGDZ_KysuiA2IjBIyZ2I6Rq_00p9MK-pXKq6SWUKvE2Z1TCJC7-qaM8zdjSdQ8HmpTP6YryXCy7OH5BQSZ2GZtrv6uAvaQDvKp5DtpLwhTwXcBJ6GV6TnBZkF8u6hytIRSi-7lV2Uh2avOBtZZHIcFCZP5CUtHxtPD3PKvjB3l2lu_Vws2W2ImCDzFcXL-TvNaW4PxHV29vYSksioL1FqEssUUzOJXcJIuWrydpZ6FeZKE4SWlOZSBPXREkaYuhw5sY8X9dXqbZ2xTsw", "127.0.0.1");

        assertThat(siteVerifyResponse.isSuccess()).isFalse();

        assertThat(siteVerifyResponse.getErrorCodes()).contains("invalid-input-secret");

        assertThat(siteVerifyResponse.getErrorCodes()).doesNotContain("missing-input-secret");
        //assertThat(siteVerifyResponse.getErrorCodes()).doesNotContain("invalid-input-secret");
        assertThat(siteVerifyResponse.getErrorCodes()).doesNotContain("missing-input-response");
        assertThat(siteVerifyResponse.getErrorCodes()).doesNotContain("invalid-input-response");

    }

    @Test
    public void wrongGReCaptchaResponseTest() throws IOException {
        // ReCaptcha Secret Key for testing purposes.
        // See: https://developers.google.com/recaptcha/docs/faq
        ReCaptchaVerify reCaptchaVerify = new ReCaptchaVerify("6LeIxAcTAAAAAGG-vFI1TnRWxMZNFuojJ4WifJWe");
        SiteVerifyResponse siteVerifyResponse = reCaptchaVerify.verify("foobar", "127.0.0.1");
        assertThat(siteVerifyResponse.isSuccess()).isFalse();
        assertThat(siteVerifyResponse.getErrorCodes()).contains("invalid-input-response");

        assertThat(siteVerifyResponse.getErrorCodes()).doesNotContain("missing-input-secret");
        assertThat(siteVerifyResponse.getErrorCodes()).doesNotContain("invalid-input-secret");
        assertThat(siteVerifyResponse.getErrorCodes()).doesNotContain("missing-input-response");
        //assertThat(siteVerifyResponse.getErrorCodes()).doesNotContain("invalid-input-response");
    }

}
