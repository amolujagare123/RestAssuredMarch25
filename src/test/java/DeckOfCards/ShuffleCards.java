package DeckOfCards;

import POJO.DeckOfCards.Cards;
import POJO.DeckOfCards.Deck;
import POJO.DeckOfCards.ResponseDrawCardsPOJO;
import io.restassured.RestAssured;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ShuffleCards {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://deckofcardsapi.com";

        Deck respShuffleCards = given().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle")
                .then().log().all().assertThat().statusCode(200)
                .body("success", equalTo(true)).extract().as(Deck.class);

       String deckId =  respShuffleCards.getDeck_id();

        System.out.println("deckId="+deckId);

        ResponseDrawCardsPOJO ob = given().queryParam("count", "3")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().assertThat().statusCode(200)
                .body("success", equalTo(true)).extract().as(ResponseDrawCardsPOJO.class);

        System.out.println("remaining="+ob.getRemaining());

        // print value and suite

        ArrayList<Cards> cards = ob.getCards();

        for (int i=0;i<cards.size();i++)
        {
            Cards card = cards.get(i);
            System.out.println("\nCard-"+i);
            System.out.println("Value="+card.getValue());
            System.out.println("Suit="+card.getSuit());
        }


    }
}
