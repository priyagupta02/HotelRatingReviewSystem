package com.lcwd.user.service.entities;
//import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Ratings")
public class Rating {
    @JsonProperty("_id")
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
