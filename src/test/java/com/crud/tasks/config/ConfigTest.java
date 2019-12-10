package com.crud.tasks.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConfigTest {
    @Autowired
    private TrelloConfig trelloConfig;

    @Autowired
    private AdminConfig adminConfig;

    @Test
    public void testAdminCongifGetter() {
        //Given

        //When
        String fetchedMail = adminConfig.getAdminMail();

        //Then
        Assert.assertEquals("jangajdakodilla@gmail.com", fetchedMail);
    }

    @Test
    public void testTrelloConfigGetter() {
        //Given

        //When
        String fetchedEndpoint = trelloConfig.getTrelloApiEndpoint();
        String fetchedAppKey = trelloConfig.getTrelloAppKey();
        String fetchedToken = trelloConfig.getTrelloToken();
        String fetchedUser = trelloConfig.getTrelloUser();

        //Then
        Assert.assertEquals("https://api.trello.com/1", fetchedEndpoint);
        Assert.assertEquals("5d72d123eac6478af0eb9b7d7cd47dfa", fetchedAppKey);
        Assert.assertEquals("205ba7d9359ccd4b2f6a5c0aceef532eb397d200b74780e4e25fa2accb9094e7", fetchedToken);
        Assert.assertEquals("jangajda", fetchedUser);
    }
}
