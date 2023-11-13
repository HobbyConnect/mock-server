package com.example.mockserver.main.api;

import com.example.mockserver.main.RequestHandler;
import com.plant.hobby.connect.api.HobbyConnectApi;
import com.plant.hobby.connect.model.LikeUserResponse;
import com.plant.hobby.connect.model.LoginUserBody;
import com.plant.hobby.connect.model.LoginUserResponse;
import com.plant.hobby.connect.model.StandardRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController implements HobbyConnectApi {


    private RequestHandler requestHandler;

    public RestController(RequestHandler requestHandler){
        this.requestHandler  =  requestHandler;
    }

    @Override
    public ResponseEntity<LikeUserResponse> postLikeUser(String userID, StandardRequestBody standardRequestBody) {
        //valid check session ID:
        log.info("POST LikeUser");
        return requestHandler.postLikeUser(userID);
    }

    @Override
    public ResponseEntity<LoginUserResponse> postLoginUser(LoginUserBody loginUserBody) {
        log.info("POST LoginUser");
        return requestHandler.postLoginUser(loginUserBody);
    }
}
