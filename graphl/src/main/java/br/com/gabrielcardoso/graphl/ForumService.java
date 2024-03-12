package br.com.gabrielcardoso.graphl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
class PostService {
    Map<String, Post> posts = new HashMap<>();

    Collection<Post> create(String content) {
        var newPost = new Post(UUID.randomUUID().toString(), content);
        posts.put(newPost.id(), newPost);
        return findAll();
    }

    Post findById(String id) {
        return posts.get(id);
    }

    Collection<Post> findAll() {
        return posts.values();
    }
}


@Service
class CommentService {
    Map<String, Comment> comments = new HashMap<>();
    Collection<Comment> create(String content, String postId) {
        var newComment = new Comment(UUID.randomUUID().toString(), content, postId);
        comments.put(newComment.id(), newComment);
        return comments.values();
    }

    Comment findById(String id) {
        return comments.get(id);
    }
}