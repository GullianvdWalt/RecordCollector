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
import com.gvdw.RecordCollector.Services.RecordsService;


@Controller
public class RecordsController {
    
    @Autowired
    private RecordsService recordService;
    
    
   @RequestMapping(value = {"/", "/index"})
    public String showPage(Model model){
       //Get List of Products
       List<Records> listRecords = recordService.listAll();
       model.addAttribute("listRecords", listRecords);
       
       
       return "index";
    }
    
    
    
}
