package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrelloMapperTest {
    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void testMappingBoard() {
        //Given
        List<TrelloListDto> listDtos = new ArrayList<>();
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "To Do", listDtos);
        trelloBoardDtos.add(trelloBoardDto);

        //When
        List<TrelloBoard> mappedBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        List<TrelloBoardDto> mappedBoardDtos = trelloMapper.mapToBoardsDto(mappedBoards);

        //Then
        Assert.assertEquals(TrelloBoard.class, mappedBoards.get(0).getClass());
        Assert.assertEquals(TrelloBoardDto.class, mappedBoardDtos.get(0).getClass());
    }

    @Test
    public void testMappingList() {
        //Given
        List<TrelloList> lists = new ArrayList<>();
        TrelloList trelloList = new TrelloList("1", "To Do", true);
        lists.add(trelloList);

        //When
        List<TrelloListDto> mappedListDtos = trelloMapper.mapToListDto(lists);
        List<TrelloList> mappedLists = trelloMapper.mapToList(mappedListDtos);

        //Then

        Assert.assertEquals(TrelloList.class, mappedLists.get(0).getClass());
        Assert.assertEquals(TrelloListDto.class, mappedListDtos.get(0).getClass());
    }

    @Test
    public void testMappingCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Task 1", "Test", "Bottom", "1");

        //When
        TrelloCardDto mappedCardDto = trelloMapper.mapToCardDto(trelloCard);
        TrelloCard mappedCard = trelloMapper.mapToCard(mappedCardDto);

        //Then
        Assert.assertEquals(TrelloCard.class, mappedCard.getClass());
        Assert.assertEquals(TrelloCardDto.class, mappedCardDto.getClass());
    }
}
