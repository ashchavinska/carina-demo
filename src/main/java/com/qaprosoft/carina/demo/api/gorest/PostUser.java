package com.qaprosoft.carina.demo.api.gorest;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostUser extends AbstractApiMethodV2 {
    public PostUser() {
        super("api.gorest/_post/rq.json", "api.gorest/_post/rs.json", "api.gorest/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        request.header("Authorization", "Bearer " + Configuration.getEnvArg("token"));
    }
}
