package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    private final TrelloListDto trelloListDto = new TrelloListDto("1", "Wiesiu", true);
    private final TrelloListDto trelloListDto1 = new TrelloListDto("2", "Robert", false);
    private final TrelloList trelloList = new TrelloList("1", "Wiesiu", true);
    private final TrelloList trelloList1 = new TrelloList("2", "Robert",false);

    @Test
    void mapToBoardsTest() {
        //Given
        List<TrelloListDto> lists = List.of(trelloListDto, trelloListDto1);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "Kaziu", lists);
        List<TrelloBoardDto> lists1 = List.of(trelloBoardDto);
        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(lists1);
        //Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2,result.get(0).getLists().size());

    }

    @Test
    void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> lists = List.of(trelloList,trelloList1);
        TrelloBoard trelloBoard = new TrelloBoard("1", "Kaziu", lists);
        List<TrelloBoard> lists1 = List.of(trelloBoard);
        //When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(lists1);
        //Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2,result.get(0).getLists().size());
    }

    @Test
    void mapToListTest() {
        //Given
        List<TrelloListDto> lists = List.of(trelloListDto, trelloListDto1);
        //When
        List<TrelloList> result = trelloMapper.mapToList(lists);
        //Then
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void mapToListTestDto() {
        //Given
        List<TrelloList> lists = List.of(trelloList, trelloList);
        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(lists);
        //Then
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Tomek", "Test", "test", "1");
//        TrelloCard trelloCard1 = new TrelloCard("Karol", "Test1", "test1", "2");
        //When
        TrelloCardDto mapToCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals(mapToCardDto.getDescription(),trelloCard.getDescription());
        assertEquals(mapToCardDto.getListId(),trelloCard.getListId());
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto trelloCard = new TrelloCardDto("Karol", "Test1", "test1", "2");
        //When
        TrelloCard mapToCard = trelloMapper.mapToCard(trelloCard);
        //Then
        assertEquals(mapToCard.getName(),trelloCard.getName());
        assertEquals(mapToCard.getPos(),trelloCard.getPos());


    }

}
