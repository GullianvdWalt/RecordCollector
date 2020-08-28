/*
 * This is the ProductController Class
 * The Spring ProductService is injected into the class
 *
 */


/*
* Created By Gullian Van Der Walt 2020
*/

package com.gvdw.RecordCollector.Controllers;

//Imports
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gvdw.RecordCollector.Models.Records;
import com.gvdw.RecordCollector.Repositories.SortRepo;
import com.gvdw.RecordCollector.Services.RecordsService;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import java.util.stream.Collectors;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller public class RecordsController {

    //Inject Services
    @Autowired private RecordsService recordService;

//    @Autowired private SortRepo sortRepository; 
  
        @RequestMapping("/")
        public String viewHome(Model model){
          String keyword = null;
          return getRecords(model, 1, "artist", "asc", keyword);
        }
        
        @RequestMapping("/page/{pageNum}")
        public String getRecords(Model model,
                                 @PathVariable(name = "pageNum") int pageNum, 
                                 @Param("sortField") String sortField,
                                 @Param("sortDir") String sortDir,
                                 @Param("keyword") String keyword){

        Page<Records> page = recordService.listAll(pageNum, sortField, sortDir, keyword);
            
        List<Records> listRecords = page.getContent();

        model.addAttribute("currentPage", pageNum);
	model.addAttribute("totalPages", page.getTotalPages());
	model.addAttribute("totalItems", page.getTotalElements());
        // Sorting
        model.addAttribute("sortField", sortField);
	model.addAttribute("sortDir", sortDir);
	model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listRecords", listRecords);
        model.addAttribute("keyword",keyword);
        
        return "index";
    }
    
        
  
    // Add New Record
    @PostMapping("/addNew")
    public String addNew(Records records){
        recordService.save(records);
        return "redirect:/";
    }
        //Find Record By Id
    @RequestMapping("/findById")
    @ResponseBody
    public Optional<Records> findById(Long id){
       return recordService.findById(id);
    } 

        //Edit Record
    @RequestMapping(value="/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(Records records) {
        recordService.save(records);
        return "redirect:/";
    }
    
    
    // Delete Record
    @RequestMapping(value="/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id){
        recordService.delete(id);
        return "redirect:/";
    }

}
