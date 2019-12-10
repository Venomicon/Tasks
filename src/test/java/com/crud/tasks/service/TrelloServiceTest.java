package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.MailException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {
    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Test
    public void testFetchTrelloBoards() {
        //When
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();

        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);

        //When
        List<TrelloBoardDto> fetchedBoards = trelloService.fetchTrelloBoards();

        //Then
        Assert.assertEquals(0, fetchedBoards.size());
    }

    @Test
    public void testCreateCard() {
        //When
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card", "Description", "Bottom", "1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "Test", "url");

        when(trelloClient.createNewCard(any())).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto fetchedCard = trelloService.createTrelloCard(trelloCardDto);

        //Then
        Assert.assertTrue(fetchedCard.equals(createdTrelloCardDto));
    }
}
