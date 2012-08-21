package com.cyonide.booksniffer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cyonide.booksniffer.dao.AuthorDAO;
import com.cyonide.booksniffer.entities.Author;


@Controller
@SessionAttributes
public class AuthorController {

    @Autowired
    private AuthorDAO authorDAO;

    @RequestMapping(value="/addAuthor", method=RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author") Author author, BindingResult result){
        
        System.out.println("Author Name " + author.getAuthorName());
        System.out.println("Author Last Name "+ author.getAuthorLastName());
        authorDAO.addAuthor(author);
        
        return "redirect:authorList.html";
    }
    
    
    @RequestMapping("/author")
    public ModelAndView author(){
        return new ModelAndView("author", "command", new Author());
    }
    
    
    @RequestMapping("/authorList")
    public String authorList(ModelMap modelMap){
    	 List<Author> authors = authorDAO.listAuthor();
    	 modelMap.addAttribute("authors", authors);
    	 for(Author author : authors){
    		 System.out.println("Author name: " + author.getAuthorName() + " Last name " + author.getAuthorLastName());
    	 }
    	 return "authorList";
    }
    
    
       
}
    
    
   