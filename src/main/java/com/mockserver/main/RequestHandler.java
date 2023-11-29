package com.mockserver.main;

import com.hobby.connect.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RequestHandler {

    private final static String SESSION_ID =  "sess_84266fdbd31d4c2c6d0665f7e8380fa3";


    public ResponseEntity<NewsResponse>  news(Integer pageNr){

        NewsResponse  response =  new NewsResponse();
        int start;
        int stop;
        if(pageNr == 0 ){
            start = 0;
            stop  = 5;
        }else if(pageNr == 1){
            start = 5;
            stop = 10;
        }else {
            News news =  new News() ;
            news.setId("NULL");
            response.addNewsItem(news);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        for(int  i = start ; i != stop; i ++){
            News news  =  new News() ;
            news.setId(UUID.randomUUID().toString());
            news.setPublished(i+"0 min");
            news.setText(i +" - Hobby ist jetzt verfuegbar!!! Los und probiere es aus");
            news.setUserName("Hobby-Connect-Team");
            news.setUserPic("https://img.fotocommunity.com/profilbild-deabb511-62e9-4582-bd2c-0a11ac10ef4b.jpg?height=1000");
            news.setPic("https://www.bd-palavas.fr/wp-content/uploads/2019/09/sport-duree.jpeg");
            response.addNewsItem(news);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    public ResponseEntity<NextUsersResponse> getNextUsers() {
        NextUsersResponse response = new NextUsersResponse();

        for(int i = 0  ;   i !=   5 ; i++ ){
           NextUser nextUser   = new NextUser() ;
           nextUser.setAge(25-i);
           nextUser.setId(String.valueOf(UUID.randomUUID()));
           nextUser.setType("user");
           nextUser.setDescription("Hallo ich bin "+i);
           nextUser.setName("OSKAR_"+i);
           nextUser.setLocation("Wuerzburg");
           for(int k = 0 ; k != 3; k++){
                Content content  =  new Content();
                content.setType("hobby");
                content.setId(String.valueOf(UUID.randomUUID()));
                content.setName("Joggen");
                content.setDescription("Joggen ist eine Sportart bei der es darum geht moeglichst lange zu laufen");
                content.img("https://cdn0.iconfinder.com/data/icons/woman-walking-and-running-movements/233/woman-walking-009-512.png");
                //Calendar
                CalendarWidget widget =  new CalendarWidget();
                widget.setType("widget/calender");
                CalendarWidgetDays days =  new CalendarWidgetDays();
                days.setFriday(true);
                days.setMonday(true);
                widget.setCalendarWidgetDays(days);
                content.addWidgetDataItem(widget);
                //Location
               LocationWidget locationWidget =  new LocationWidget();
               locationWidget.setType("widget/location");
               locationWidget.setLocation("Hoechberg Waldsportplatz");
               locationWidget.setTime("17:00");
               content.addWidgetDataItem(locationWidget);

                for(int b = 0 ; b !=  2; b++){
                    Post post = new Post();
                    post.setType("post");
                    post.setId(String.valueOf(UUID.randomUUID()));
                    post.setName("Mein Post Nr. "+b);
                    post.setDescription("Ich war letzten Sonnatg joggen und habe diesen Fuchs gesehen #joggen");
                    post.setImg("https://www.waisttrainerfactory.com/wp-content/uploads/2020/08/818-1.jpg");
                    content.addPostsItem(post);
                }

                nextUser.addContentItem(content);
           }
            response.addNextUsersItem(nextUser);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public ResponseEntity<LoginUserResponse> postLoginUser(LoginUserBody loginUserBody){
        log.info("Email: " + loginUserBody.getEmail());
        log.info("PW   : " + loginUserBody.getPassword());
        LoginUserResponse response  = new LoginUserResponse() ;
        response.setTtl(4000);
        response.setRefreshToken("RjY2NjM5NzA2OWJjuE7c");
        response.setSessionId(SESSION_ID);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public ResponseEntity<LogoutUserResponse> logoutUser(String SessionID){
        LogoutUserResponse response  =  new LogoutUserResponse();
        response.setCompleted(true);
        response.setSessionID(SessionID);
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

    public ResponseEntity<ProfilePage> getProfilePage(){
        ProfilePage response =  new ProfilePage() ;
        response.type("user");
        response.setId("asdjfoiasjdfuaw39fj8hjf");
        response.setName("Oskar");
        response.setSurname("Herrmann");
        response.setAge(19);
        response.setLocation("Wuerzburg");
        response.setAccountCreation("01.11.2023");
        response.setDescription("Ich bin der Oskar");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<UpdateProfilePageResponse> putUpdateProfilePage(){
        UpdateProfilePageResponse response  = new UpdateProfilePageResponse();
        response.setId("asdjfoiasjdfuaw39fj8hjf");
        response.setCompleted(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
