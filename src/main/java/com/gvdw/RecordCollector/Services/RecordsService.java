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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class RecordsService{
    
    //Inject Record Repo
    @Autowired private RecordsRepoisitory recordsRepo;

      //Methods
    
    //List all the products from the record_collection DB
    public List<Records> listAll(){
        return recordsRepo.findAll();
    }
    
    //Save New Country From Country.html Form
    public void save(Records records){
        recordsRepo.save(records);
    }

   //Get Country by id
    public Optional<Records> findById(Long id){
        return recordsRepo.findById(id);
    }

    //Delete Record
    public void delete(Long id) {
      recordsRepo.deleteById(id);
    }
}
