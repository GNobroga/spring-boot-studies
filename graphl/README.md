```graphql

query {
    posts {
        id,
        content
    }

}

mutation {
  createPost(input: { content: "celular" }) {
    ...getContent
  }
}

fragment getContent on Post {
  content
}
```