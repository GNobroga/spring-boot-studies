package br.com.gabrielcardoso.graphl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ForumController {
    
    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @QueryMapping
    public Collection<Post> posts() {
        return postService.findAll();
    }

    //@SchemaMapping(typeName = "Query", value = "findPostById")
    @QueryMapping
    public Post findPostById(@Argument String id) {
        return postService.findById(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument("input") CreatePostInput createPostInput) {
        System.out.println(createPostInput);
        return postService.create(createPostInput.getContent());
    }


}
