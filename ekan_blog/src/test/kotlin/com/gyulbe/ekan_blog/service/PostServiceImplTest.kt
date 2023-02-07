package com.gyulbe.ekan_blog.service

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.repository.PostRepository
import com.gyulbe.ekan_blog.requests.post.PostRequests
import com.gyulbe.ekan_blog.service.post.PostServiceImpl
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

@SpringBootTest
class PostServiceImplTest @Autowired constructor(
    private val postRepository: PostRepository,
    private val postServiceImpl: PostServiceImpl
) {

    @AfterEach
    fun clean() {
        postRepository.deleteAll()
    }

    @Test
    @DisplayName("포스트 생성이 정상 동작한다.")
    fun createPostTest() {
        // given
        val request = PostRequests("테스트 제목입니다.", "테스트 부제목입니다.", "테스트 내용입니다.")

        // when
        postServiceImpl.createPost(request)

        // then
        val results = postRepository.findAll()
        assertThat(results).hasSize(1)
        assertThat(results[0].title).isEqualTo("테스트 제목입니다.")
        assertThat(results[0].subTitle).isEqualTo("테스트 부제목입니다.")
        assertThat(results[0].content).isEqualTo("테스트 내용입니다.")
    }

    @Test
    @DisplayName("포스트 목록 조회가 정상 동작한다")
    fun getPostsTest() {
        // given
        postRepository.saveAll(
            listOf(
                Post("테스트", "부제목입니다", "내용입니다"),
                Post("테스트2", "부제목입니다2", "내용입니다2"),
                Post("테스트3", "부제목입니다3", "내용입니다3")
            )
        )

        // when
        val pageable = PageRequest.of(0, 20)
        val secondPageRequest = PageRequest.of(1, 2)
        val posts = postServiceImpl.getPosts(pageable)
        val secondPagePosts = postServiceImpl.getPosts(secondPageRequest)

        // then
        assertThat(posts).hasSize(3)
        assertThat(posts).extracting("title").containsExactlyInAnyOrder("테스트", "테스트2", "테스트3")
        assertThat(posts).extracting("subTitle").containsExactlyInAnyOrder("부제목입니다", "부제목입니다2", "부제목입니다3")
        assertThat(posts).extracting("content").containsExactlyInAnyOrder("내용입니다", "내용입니다2", "내용입니다3")

        assertThat(secondPagePosts).hasSize(1)
        assertThat(secondPagePosts.content[0].title).isEqualTo("테스트3")
        assertThat(secondPagePosts.content[0].subTitle).isEqualTo("부제목입니다3")
        assertThat(secondPagePosts.content[0].content).isEqualTo("내용입니다3")
    }

//    @Test
//    @DisplayName("포스트 정보 조회가 정상 동작한다")
//    fun getPostTest() {
//        // given
//        val postId = 1L
//        postRepository.save(Post("테스트", "부제목입니다", "내용입니다", id = postId))
//
//        // when
//        val post = postService.getPostById(1)
//
//        // then
//        assertThat(post).isNotNull
//        assertThat(post).extracting("title").
//
//    }
}