package edu.harvard.e57.controller;

import edu.harvard.e57.model.Movie;
import edu.harvard.e57.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieListController {

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(path = "/movieList" , method = RequestMethod.GET)
    public String showMovies(Model model){
        model.addAttribute("movie", new Movie());
        return "index";
    }

    @PostMapping(path = "/movieList")
    public String addMovie(@ModelAttribute("movie") Movie movie, Model model){

        movieRepository.save(movie);

        model.addAttribute("movies" , movieRepository.findAllByViewer(movie.getViewer()));
        return "index";
    }

    //Not a requirement - just added a functionality of a search bar
    @PostMapping("/searchBar")
    public String searchMovie(@ModelAttribute("movie") Movie movie, Model model){
        if(movieRepository.findAllByViewer(movie.getViewer()) != null) {
            model.addAttribute("movies", movieRepository.findAllByViewer(movie.getViewer()));
        }
        return "index";
    }
}
