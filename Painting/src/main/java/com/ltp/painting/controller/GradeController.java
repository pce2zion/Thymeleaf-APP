package com.ltp.painting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



import java.util.*;

@Controller
public class GradeController {

    @GetMapping("/grades")
    public  String getGrade(Model model){
        model.addAttribute("grades", 30);
       return "grades";
    }

    @GetMapping("/")
    public String getMethodName(Model model){
        model.addAttribute("grades", 30);
        return "movies";
    }

    //the controller maps the users request to that particular handler method
    //the handler method has access to the model a model is a container that holds data
//    public String getMovies(Model model){
//
//        //normal method for when you want to populate just one
//               Movies movies = new Movies("Azimuth", "obiwan", "1");
//               model.addAttribute("movies", movies);
//                return "movies";
//        // this "movies" is the movies.html view template
//
//
//    }
//
    @GetMapping("/movies")
    public ModelAndView getMovies(ModelAndView mav){
//when you want to populate many
        Movies movies1 = Movies.builder()
                .title("Breaking Bad")
                .name("obiwan")
                .ratings("10.0")
                .build();

        Movies movies3 = Movies.builder()
                .title("Peak")
                .name("goodness")
                .ratings("9.9")
                .build();

        Movies movies2 = Movies.builder()
                .title("Azimuth")
                .name("star wars")
                .ratings("9.9")
                .build();

        Movies movies4 = Movies.builder()
                .title("Lantern")
                .name("obiwan")
                .ratings("9.9")
                .build();

        List<Movies> moviesList = new ArrayList<Movies>();
        moviesList.add(movies1);
        moviesList.add(movies2);
        moviesList.add(movies3);
        moviesList.add(movies4);


        mav.addObject( "movies", moviesList);
        mav.setViewName("movies");
        return mav;

    }
    @GetMapping("/get")
    public ModelAndView getAllList(ModelAndView mav ){
        List<String> products = new ArrayList<String>();
        products.add("Beer");
        products.add("Root");
        products.add("can");

        mav.addObject("products", products);
        mav.setViewName("movies");
        return mav;
    }

    @GetMapping("/great")
    public String showSpeed(Model model){
        model.addAttribute("speed", 45);
        return "grades";
    }

    @GetMapping("/show")
    public String isContains(Model model){
        model.addAttribute("menu", "we have rice cakes on this menu");
        return "grades";
    }


}
