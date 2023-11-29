package com.mockserver.main.api;

import com.hobby.connect.api.HobbyConnectApi;
import com.hobby.connect.model.*;
import com.mockserver.main.RequestHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController implements HobbyConnectApi {

    private RequestHandler requestHandler;

    public RestController(RequestHandler requestHandler){
        this.requestHandler  =  requestHandler;
    }

    @Override
    @CrossOrigin()
    public ResponseEntity<NextUsersResponse> getNextUsers(String sessionID) {
        //valid check session ID etc.
        log.info("GET NextUsers");
        return requestHandler.getNextUsers();
    }

    @Override
    @CrossOrigin()
    public ResponseEntity<ProfilePage> getProfilePage(String sessionID) {
        log.info("GET ProfilePage");
        return requestHandler.getProfilePage();
    }

    @Override
    @CrossOrigin()
    public ResponseEntity<LogoutUserResponse> getLogoutUser(String sessionID) {
        log.info("GET LogoutUser");
        return requestHandler.logoutUser(sessionID);
    }

    @Override
    public ResponseEntity<NewsResponse> getNews(String sessionID, Integer pageNr) {
        log.info("GET News | Page: " + pageNr);
        return requestHandler.news(pageNr);
    }

    @Override
    @CrossOrigin()
    public ResponseEntity<LikeLogicResponse> postDisLikeUser(String userId, String sessionId) {
        //valid check session ID:
        log.info("POST DislikeUser");
        return requestHandler.postDisLikeUser(userId);
    }

    @Override
    @CrossOrigin()
    public ResponseEntity<LikeLogicResponse> postLikeUser(String userID, String sessionId) {
        //valid check session ID:
        log.info("POST LikeUser");
        return requestHandler.postLikeUser(userID);
    }

    @Override
    @CrossOrigin()
    public ResponseEntity<LoginUserResponse> postLoginUser(LoginUserBody loginUserBody) {
        log.info("POST LoginUser");
        return requestHandler.postLoginUser(loginUserBody);
    }

    @Override
    @CrossOrigin()
    public ResponseEntity<UpdateProfilePageResponse> putUpdateProfilePage(String sessionID, ProfilePage profilePage) {
        log.info("PUT UpdateProfilePage");
        return requestHandler.putUpdateProfilePage();
    }
}
