package com.company.musicstorecatalog.repository;

import com.company.musicstorecatalog.model.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class LabelRepositoryTest {
/*
    @Autowired
private LabelRepository repo;
    @Before
    public void setUp() throws Exception {
        //bo dalej dodajemy do testów co namślina na język przyniesie i musimy to usunąć
        repo.deleteAll();
    }
    @Test
    public void shouldInteractWithLabelTableInDataBase() {
        //idzie do bazy
        Label label = new Label("aaa", "bbb");
        // sztuczne nie idzie dobazy
        Label expectedLabel = new Label("aaa", "bbb");
        //act
        repo.save(label);
        // ustawia taki sam id jak się ustawił w bazie
        expectedLabel.setId(label.getId());
        //assert
        assertEquals(expectedLabel, label);
//inny test . czy wyświetli wszystko z bazy -a tam tylko nasza linija
        //act
        List<Label> allTheLabel = repo.findAll();
        //assert
        assertEquals(1, allTheLabel.size());
        //act
        repo.deleteById(label.getId());
        allTheLabel = repo.findAll();
        assertEquals(0, allTheLabel.size());
    }



*/


    }
