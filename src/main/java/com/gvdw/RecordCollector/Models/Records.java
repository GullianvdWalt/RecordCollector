/*
 * 
 * This is the Records Enitity Class
 * 
 * Represented in the Recordsdb with table vinyl_records 
  
 */

/*
* Created By Gullian Van Der Walt 2020
*/
package com.gvdw.RecordCollector.Models;

//Imports
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor    
public class Records {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String artist;
    private String album;
    private String catalog_number;
    private String format;
    private String cover_condition;
    private String record_condition;
    private String pressing;
    private String remarks;
    private String album_release_date;
    private boolean on_discogs;
    private String discogs_link;
    
    //Constructors implemented by Lombok
    //Getters and Setters implemented by Lombok
    
}
