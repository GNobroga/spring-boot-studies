package br.com.gabrielcardoso.graphl;

record Post(String id, String content) {}

record Comment(String id, String content, String postId) {}
