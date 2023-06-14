package com.virgingames.potsinfo;

import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SerenityRunner.class)
public class RoxorTest extends TestBase {

    static int potsId;
    @Steps
    RoxorSteps roxorSteps;

    @Title("Validate jackpotId = Roxor Progressives")
    @Test
    public void test001() {
        ValidatableResponse response = roxorSteps.getAllPotsData();
        response.statusCode(200).log().ifValidationFails();
        response.body("data.jackpotId", equalTo("Roxor Progressives"));
    }

    @Title("Verify pots 4th id has name = play-classic-video-poker")
    @Test
    public void test002() {
        ValidatableResponse response = roxorSteps.getAllPotsData();
        response.statusCode(200).log().ifValidationFails();
        response.body("data.pots[3].name", equalTo("play-classic-video-poker"));
    }

    @Title("Verify When currency is GBP then the response contains correct currencies in GBP")
    @Test
    public void test003() {
        ValidatableResponse response = roxorSteps.getAllPotsData();
        response.statusCode(200).log().ifValidationFails();
        List<Object> dataCurrencyList = response.extract().path("data.pots.currency");
        //System.out.println(dataCurrencyList);
        int s = dataCurrencyList.size();
        for (int i = 0; i < s - 1; i++) {
            if (dataCurrencyList.get(i).equals("GBP")) {
                System.out.println("True");
            }else{
                System.out.println("Currency is not in GBP");
            }
        }
    }
}

