package ru.netology

fun main() {
    println(posts)
}

data class Post(

    var ownerId: Int = 1,
    val friendsOnly: Boolean = true,
    val fromGroup: Boolean = true,
    val message: String = "New post",
    val publishDate: Int = 166622525
)


object WallService

private val unicalId: Int = 100

var posts = emptyArray<Post>()
fun add(post: Post): Post {
    post.ownerId = post.ownerId + unicalId
    return posts.last()
}

fun update (post: Post): Boolean {
    for ((index, post) in posts.withIndex()) {
        if (posts.equals(post.ownerId)){
            posts[index] = post.copy(friendsOnly = true, fromGroup = true, message = "Second message")
        }
    }
    return false
}
