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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller public class RecordsController {

    //Inject Services
    @Autowired private RecordsService recordService;

    @Autowired private SortRepo sortRepository;    
    
        @GetMapping("/")
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
	model.addAttribute("totalPages", page.getTotalPages());
	model.addAttribute("totalItems", page.getTotalElements());
        return "index";
    }
    
    @PostMapping("/addNew")
    public String addNew(Records records){
        recordService.save(records);
        
        return "redirect:/";
    }

        //Edit The Products
    @RequestMapping("/edit/{id}")
    public ModelAndView showRecordEidtPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_record");
        Records record = recordService.get(id);
        mav.addObject("record", record);
        return mav;
    }
    
        //Save Product
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Records record){
        recordService.save(record);
        
        return "redirect:/records";
    }
        
}
