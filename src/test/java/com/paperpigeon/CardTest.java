package com.paperpigeon;
import com.paperpigeon.dto.CardDTO;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Laura on 3/30/2017.
 */
public class CardTest {

    @Test
    public void checkIfTitleIsCorrect() {
        CardDTO card  = new CardDTO();
        card.setImagePath("E:/images");
        card.setMessage("Happy Bday");
        card.setPrice(29.9);
        card.setTitle("getting old");
        Assert.assertEquals(card.getMessage(), "getting old");
    }

    @Test
    public void checkIfPriceIsCorrect() {
        CardDTO card  = new CardDTO();
        card.setImagePath("E:/images");
        card.setMessage("Happy Bday");
        card.setPrice(29.9);
        card.setTitle("getting old");
        Assert.assertEquals(card.getPrice(), 29.9, 0.001);
    }

    @Test
    public void checkIfImagePathIsCorrect() {
        CardDTO card  = new CardDTO();
        card.setImagePath("E:/images");
        card.setMessage("Happy Bday");
        card.setPrice(29.9);
        card.setTitle("getting old");
        Assert.assertEquals(card.getImagePath(),"E:/images");
    }

    @Test
    public void checkIfMessageIsCorrect() {
        CardDTO card  = new CardDTO();
        card.setImagePath("E:/images");
        card.setMessage("Happy Bday");
        card.setPrice(29.9);
        card.setTitle("getting old");
        Assert.assertEquals(card.getMessage(),"Happy Bday");
    }
}
