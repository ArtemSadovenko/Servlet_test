package Servlet_App;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private long id;
    private String name;
    private String author;

//    private static long currentId = -1;
//
//    public static long giveId(){
//        currentId++;
//        return currentId;
//    }
}
