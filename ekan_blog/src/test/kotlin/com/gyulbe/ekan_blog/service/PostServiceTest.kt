package com.gyulbe.ekan_blog.service

import com.gyulbe.ekan_blog.domain.post.Post
import com.gyulbe.ekan_blog.repository.PostRepository
import com.gyulbe.ekan_blog.requests.post.PostCreateRequest
import com.gyulbe.ekan_blog.service.post.PostService
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@SpringBootTest
class PostServiceTest @Autowired constructor(
    private val postRepository: PostRepository,
    private val postService: PostService
) {

    @AfterEach
    fun clean() {
        postRepository.deleteAll()
    }

    @Test
    @DisplayName("포스트 생성이 정상 동작한다.")
    fun createPostTest() {
        // given
        val request = PostCreateRequest("테스트 제목입니다.", "테스트 부제목입니다.", "테스트 내용입니다.")

        // when
        postService.createPost(request)

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
        val pageable = PageRequest.of(0, 20, Sort.Direction.DESC, "id")
        val posts = postService.getPosts(pageable)

        // then
        assertThat(posts).hasSize(3)
        assertThat(posts).extracting("title").containsExactlyInAnyOrder("테스트", "테스트2", "테스트3")
        assertThat(posts).extracting("subTitle").containsExactlyInAnyOrder("부제목입니다", "부제목입니다2", "부제목입니다3")
        assertThat(posts).extracting("content").containsExactlyInAnyOrder("내용입니다", "내용입니다2", "내용입니다3")
    }
}