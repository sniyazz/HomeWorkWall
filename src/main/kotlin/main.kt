package ru.netology

fun main() {
    val postOne = WallService.add(Post())
    val postTwo = WallService.add(Post())

    println(WallService.posts.size)
    println(WallService.posts.get(0))
    println(WallService.posts.get(1))
    println(WallService.posts.toList())
    WallService.update(Post(1, 2, true, true, "New post", 16622525))
    println(WallService.posts.toList())
    println(postOne.id)
    println(postTwo.message)

}

var unicalId: Int = 2

data class Post(
    val id: Int = unicalId++,
    val ownerId: Int = 100,
    val friendsOnly: Boolean = true,
    val fromGroup: Boolean = true,
    val message: String = "New post",
    val publishDate: Int = 166622525
)

object WallService {

    var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, pos) in posts.withIndex()) {
            if (pos.id == post.id) {
                posts[index] = post.copy(
                   // id = posts[index].id,
                    ownerId = posts[index].ownerId,
                    friendsOnly = posts[index].friendsOnly,
                    fromGroup = posts[index].fromGroup,
                    message = posts[index].message,
                  //  publishDate = posts[index].publishDate
                )
                return true
            }
        }
        return false
    }
}
