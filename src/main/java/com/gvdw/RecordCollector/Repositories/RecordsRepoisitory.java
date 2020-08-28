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
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;


@Repository
public interface RecordsRepoisitory extends PagingAndSortingRepository<Records, Long>{
 
        @Query(value ="SELECT * FROM records WHERE "
                + " records.artist LIKE ?1% OR records.album LIKE ?1% "
                + " OR records.format LIKE ?1%", nativeQuery = true)
        public Page<Records> findAll(String keyword, Pageable pageable);
}
// OR records.catalog_number LIKE '%?1%' " 
//                + " '%?1%' OR records.cover_condition LIKE '%?1%' OR records.record_condition LIKE '%?1%' OR " 
//                + "records.pressing LIKE '%?1%' OR records.remarks LIKE '%?1%' OR records.year LIKE '%?1%'