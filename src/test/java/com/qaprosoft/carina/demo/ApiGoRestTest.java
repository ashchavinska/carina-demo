package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.gorest.DeleteUser;
import com.qaprosoft.carina.demo.api.gorest.GetUserById;
import com.qaprosoft.carina.demo.api.gorest.PostUser;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class ApiGoRestTest extends AbstractTest {

    int userID = 0;

    @Test(description = "01")
    @MethodOwner(owner = "ashchavinska")
    public void testPostUser() throws Exception {
        PostUser api = new PostUser();
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        String rs = api.callAPI().asString();
        api.validateResponse();
        userID = Integer. parseInt(new JsonPath(rs).getString("data.id"));
    }

    @Test(description = "02")
    @MethodOwner(owner = "ashchavinska")
    public void testGetUserByUserID() throws Exception {
        GetUserById api = new GetUserById(userID);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }

    @Test(description = "03")
    @MethodOwner(owner = "ashchavinska")
    public void testDeleteUser() throws Exception {
        DeleteUser api = new DeleteUser(userID);
        api.expectResponseStatus(HttpResponseStatusType.OK_200);
        api.callAPI();
        api.validateResponse();
    }
}
