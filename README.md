# ReCAPTCHA v2 site verify for JAVA

This is a simple library for implementing the server side Google ReCAPTCHA site verify.

## Using maven:

Add this dependency to your `<dependencies>` section.

    <dependency>
        <groupId>io.github.keetraxx</groupId>
        <artifactId>recaptcha</artifactId>
    </dependency>
    
## Using gradle:
Add this line to your build.gradle:

    compile("io.github.keetraxx:recaptcha:0.5")

## Get a ReCAPTCHA API Key
https://www.google.com/recaptcha/admin
    
## Sample code
    ReCaptchaVerify reCaptchaVerify = new ReCaptchaVerify("MY_SECRET_KEY");
    SiteVerifyResponse siteVerifyResponse = reCaptchaVerify.verify("RECAPTCHARESPONSEDATA", "USER_REMOTE_IP");
    if ( siteVerifyResponse.isSuccess() ) {
        // do stuff
    } else {
        // do other stuff
    }
    
## Run sample

    $ git clone https://github.com/KeeTraxx/recaptcha.git
    $ mvn -Pexample spring-boot:run

Open browser at http://localhost:8080

## Run sample with your own API keys

Put your keys in `src/main/resources/application.properties`.

    $ mvn -Pexample spring-boot:run

Open browser at http://localhost:8080
