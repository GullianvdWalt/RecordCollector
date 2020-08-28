/*
 * This is the RecordsService Class
 * The RecordsRepository is injected via spring autowired annotation
 * The Spring Data JPA will generate a proxy instance at rumtime of the 
 * RecordsRepository and inject this class, the RecordsService.
 * 


     Created By Gullian Van Der Walt 2020

 */

package com.gvdw.RecordCollector.Services;

//Imports
import com.gvdw.RecordCollector.Repositories.RecordsRepoisitory;
import com.gvdw.RecordCollector.Models.Records;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class RecordsService{
    
    //Inject Record Repo
    @Autowired private RecordsRepoisitory recordsRepo;

      //Methods
    
    //List all the products from the record_collection DB
 

  public Page<Records> listAll(int pageNum, String sortField, String sortDir,String keyword){
      int pageSize = 200;
      Sort sort = Sort.by("fieldName").ascending();
      Pageable pageable = PageRequest.of(pageNum-1 , 200,
            sortDir.equals("asc") ? Sort.by(sortField).ascending()
            : Sort.by(sortField).descending());
      
      if(keyword != null){
        return recordsRepo.findAll(keyword, pageable);
      }else{
          
        return recordsRepo.findAll(pageable);
      }
      

  }
    
    //Save New Country From Country.html Form
    public void save(Records records){
        recordsRepo.save(records);
    }

    // Get Records by id
    public Optional<Records> findById(Long id){
        return recordsRepo.findById(id);
    }

    //Delete Record
    public void delete(Long id) {
      recordsRepo.deleteById(id);
    }
    

    
}
