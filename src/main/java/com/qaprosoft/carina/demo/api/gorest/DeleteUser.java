package com.qaprosoft.carina.demo.api.gorest;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteUser extends AbstractApiMethodV2 {
    public DeleteUser(int userID) {
        super(null, "api.gorest/_delete/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("userID",  String.valueOf(userID));
        request.header("Authorization", "Bearer " + Configuration.getEnvArg("token"));
    }
}
