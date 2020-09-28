package be.ugent.reeks1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class BlogPostDao {
    private Integer id;
    private HashMap<Integer,BlogPost> posts;

    public BlogPostDao(){
        id = 0;
        posts = new HashMap<Integer,BlogPost>();
        posts.put(id++,new BlogPost("titel","Hello World"));
    }

    public HashMap<Integer,BlogPost> getPosts(){
        return posts;
    }

    public BlogPost getPostById(Integer id) throws BlogPostNotFoundException{
        if(!posts.containsKey(id)){
            throw new BlogPostNotFoundException();
        }
        else {
            return posts.get(id);
        }
    }

    public int addPost(BlogPost post){
        posts.put(id++,post);
        return id++;
    }

    public void removePost(Integer id){
        posts.remove(id);
    }

    public void updatePost(Integer id, BlogPost post){
        BlogPost tussenPost = posts.get(id);
        tussenPost.setTitel(post.getTitel());
        tussenPost.setContent(post.getContent());
    }
}
