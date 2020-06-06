/*
 * This ProductRepository Interface extends the JpaRepository with the id variable
 * This interface defines the standard CRUD methods and JPA operations.
 * The JpaRepository will handle the implementation code in the from of proxy instances
 * The main function of this repository is to tell the Jpa repo the domain type, 
 * in this case the Product Entity with id opf type Long.
 */


/*
* Created By Gullian Van Der Walt 2020
*/

package com.gvdw.RecordCollector.Repositories;

//Imports
import org.springframework.data.jpa.repository.JpaRepository;
import com.gvdw.RecordCollector.Models.Records;
import org.springframework.stereotype.Repository;


@Repository
public interface RecordsRepoisitory extends JpaRepository<Records, Long>{
    
}
