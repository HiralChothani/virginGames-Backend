package com.virgingames.potsinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RoxorSteps {

    @Step("Get All data")
    public ValidatableResponse getAllPotsData() {
        return SerenityRest.given().log().ifValidationFails()
                .when()
                .get(EndPoints.CURRENCY)
                .then();
    }
}
