package com.mockserver.main;



import com.hobby.connect.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class RequestHandler {

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
