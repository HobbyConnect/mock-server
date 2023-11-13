package com.mockserver.main;


import com.plant.hobby.connect.model.LikeLogicResponse;
import com.plant.hobby.connect.model.LoginUserBody;
import com.plant.hobby.connect.model.LoginUserResponse;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RequestHandler {
    public ResponseEntity<LoginUserResponse> postLoginUser(LoginUserBody loginUserBody){
        log.info("Email: " + loginUserBody.getEmail());
        log.info("PW   : " + loginUserBody.getPassword());
        LoginUserResponse response  = new LoginUserResponse() ;
        response.setTtl(4000);
        response.setRefreshToken("RjY2NjM5NzA2OWJjuE7c");
        response.setSessionId("sess_84266fdbd31d4c2c6d0665f7e8380fa3");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<LikeLogicResponse> postDisLikeUser(String userId){
        LikeLogicResponse response  = new LikeLogicResponse();
        response.setUserId(userId);
        response.setMatched(false);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    public ResponseEntity<LikeLogicResponse> postLikeUser(String userId){
        LikeLogicResponse response  = new LikeLogicResponse();
        response.setUserId(userId);
        if(userId.equals("test1")){
            response.setMatched(true);
        }else {
            response.setMatched(false);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
