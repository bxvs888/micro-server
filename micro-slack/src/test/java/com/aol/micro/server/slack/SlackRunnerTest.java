package com.aol.micro.server.slack;

import org.junit.*;

import static com.jayway.restassured.RestAssured.*;

import com.aol.micro.server.MicroserverApp;
import com.aol.micro.server.config.Microserver;

@Microserver(properties = { "slack.webhookUri", "https://hooks.slack.com/services/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"})
public class SlackRunnerTest {

    private MicroserverApp server;

    @Before
    public void startServer() {
        server = new MicroserverApp(() -> "simple-app");
        server.start();
    }

    @After
    public void stopServer() {
        server.stop();
    }

    @Test
    public void simpleMessageTest(){
        given().when()
               .get("http://localhost:8080/simple-app/application.wadl")
               .then()
               .statusCode(200);
    }
}