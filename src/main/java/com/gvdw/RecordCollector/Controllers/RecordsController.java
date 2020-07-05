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

@Controller public class RecordsController {

    //Inject Services
    @Autowired private RecordsService recordService;

    @Autowired private SortRepo sortRepository;

//    @RequestMapping(value = {"/", "/index"})
//    public String showPage(Model model, String artistFilter, @Param("sortField") String sortField,
//        @Param("sortDir") String sortDir) {
//       //Get List of Records
//       List<Records> listRecords = recordService.listAll();
//       model.addAttribute("listRecords", listRecords);
//       return "index";
//    }
//    
    
        @GetMapping("/records")
    public String getRecords(@PageableDefault(size = 200, sort = "id") Pageable pageable,
                             Model model){
        
        Page<Records> page = sortRepository.findAll(pageable);
        List<Sort.Order> sortOrders = page.getSort().stream().collect(Collectors.toList());
        if(sortOrders.size() > 0){
            Sort.Order order = sortOrders.get(0);
            model.addAttribute("sortProperty", order.getProperty());
            model.addAttribute("sortDesc", order.getDirection() == Sort.Direction.DESC);
        }
        model.addAttribute("page", page);
        return "index";
    }
    
     
     //Method to save Country from Country Services which is from Country.html
    @PostMapping("/records/addNew")
    public String addNew(Records records){
        recordService.save(records);
        
        return "redirect:/";
    }
    //Find By Record id Method implement Service
    @RequestMapping("records/findById")
    @ResponseBody
    public Optional<Records> findById(Long id){
       return recordService.findById(id);
        
    }
    
    //When edit page is opened, submit new data
    @RequestMapping(value="records/update", method={RequestMethod.PUT, RequestMethod.GET})
    public String update(Records records){
       recordService.save(records);
        return "redirect:/index";
    }
    
    

    
//        //Delete Record
//    @RequestMapping(value="records/delete", method={RequestMethod.DELETE, RequestMethod.GET})
//    public String delete(Long id){
//        recordService.delete(id);
//        return "redirect:/index";
//    }
}
