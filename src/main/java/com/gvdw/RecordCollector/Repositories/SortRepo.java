package com.gvdw.RecordCollector.Repositories;

import com.gvdw.RecordCollector.Models.Records;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface SortRepo extends PagingAndSortingRepository<Records, Long>{
    @Query("SELECT DISTINCT r.artist FROM Records r")
    List<String> findAllArtists(Sort sort);
}
