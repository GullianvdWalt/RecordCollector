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
import com.gvdw.RecordCollector.Services.RecordsService;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String addNew(Records records,RedirectAttributes redirAttr,BindingResult result){
        
        if(result.hasErrors()){
            redirAttr.addFlashAttribute("error", "There was a problem while adding record.");
        }else{
            recordService.save(records);
            redirAttr.addFlashAttribute("success", "Record Added!");
        }
        
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
    public String update(Records records,RedirectAttributes redirAttr,BindingResult result) {
        if(result.hasErrors()){
            redirAttr.addFlashAttribute("error", "There was a problem while updating the record.");
        }else{
            recordService.save(records);
            redirAttr.addFlashAttribute("success", "Record Updated!");
        }
        return "redirect:/";
    }
    
    
    // Delete Record
    @RequestMapping(value="/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id,RedirectAttributes redirAttr,BindingResult result){
       
        if(result.hasErrors()){
            redirAttr.addFlashAttribute("error", "There was a problem while deleting the record.");
        }else{
            recordService.delete(id);
            redirAttr.addFlashAttribute("success", "Record Deleted!");
        }
        return "redirect:/";
    }

}
