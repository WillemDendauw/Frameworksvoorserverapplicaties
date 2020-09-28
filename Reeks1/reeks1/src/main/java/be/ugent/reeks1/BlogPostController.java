package be.ugent.reeks1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
public class BlogPostController {
    //@Autowired //optioneel ipv dependency injection
    private BlogPostDao dao;

    public BlogPostController(BlogPostDao dao){
        this.dao=dao;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Collection<BlogPost> GetAllPosts(){
        return dao.getPosts().values();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BlogPost getPost(@PathVariable("id") int id) throws BlogPostNotFoundException{
        try{
            return dao.getPostById(id);
        }
        catch(BlogPostNotFoundException e) {
            throw e;
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BlogPost> addPost(UriComponentsBuilder uriBuilder, @RequestBody BlogPost post){
        int id = dao.addPost(post);
        URI location = uriBuilder
                .path("/blogposts/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") int id){
        dao.removePost(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable("id") int id, @RequestBody BlogPost item){
        dao.updatePost(id,item);
    }
}
