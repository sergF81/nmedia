package ru.netology

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        author = "Нетология. Университет интернет-профессий будущего",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        published = "21 мая в 18:36",
        likedByMe = false,
        likesCount = 999,
        sharedCount = 998
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun likeOnOff() {
        post = post.copy(likedByMe = !post.likedByMe)
        data.value = post
    }
    override fun like(): Int {
        if (post.likedByMe) {
                post = post.copy(likesCount = post.likesCount + 1)
            } else {
            post = post.copy(likesCount = post.likesCount - 1)
            }
        return post.likesCount
    }
    override fun shared(): Int {
       post = post.copy(sharedCount = post.sharedCount + 1)
        return  post.sharedCount
    }

}