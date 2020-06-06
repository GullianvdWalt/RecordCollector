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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vinyl_records")
public class Records {
    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="Artist")
    private String artist;
    @Column(name="Album")
    private String album;
    @Column(name="Catalog_Number")
    private String catalog_number;
    @Column(name="Format")
    private String format;
    @Column(name="Cover_Condition")
    private String cover_condition;
    @Column(name="Record_Condition")
    private String record_condition;
    @Column(name="Pressing")
    private String pressing;
    @Column(name="Remarks")
    private String remarks;
    @Column(name="Album_Release_Date")
    private String album_release_date;
    @Column(name="On_Discogs")
    private boolean on_discogs;
    @Column(name="Discogs_Link")
    private String discogs_link;
    
    //Constructors implemented by Lombok
    //Getters and Setters implemented by Lombok
    
}
