package com.assignment.voyage.controller;

import com.assignment.voyage.dto.PostRequestDto;
import com.assignment.voyage.dto.PostResponseDto;
import com.assignment.voyage.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //    2. 전체 게시글 목록 조회 API
    //    - 제목, 작성자명, 작성 내용, 작성 날짜를 조회하기
    //    - 작성 날짜 기준 내림차순으로 정렬하기
    @GetMapping("/posts")
    public List<PostResponseDto> getPost() {
        return postService.getPost();
    }

    //    3. 게시글 작성 API
    //    - 제목, 작성자명, 비밀번호, 작성 내용을 저장하고
    //    - 저장된 게시글을 Client 로 반환하기
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }
    //4. 선택한 게시글 조회 API
    //    - 선택한 게시글의 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
    //            (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
    @GetMapping("/posts/{title}")
    public PostResponseDto getPostContent(@PathVariable String title) {
        return postService.getPostContent(title);
    }

    //5. 선택한 게시글 수정 API
    //- 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    //- 제목, 작성자명, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
    @PutMapping("/posts/{title}")
    public PostResponseDto updatePost(@PathVariable String title, @RequestBody PostRequestDto postRequestDto) throws Exception {
        return postService.updatePost(title, postRequestDto);
    }

    //6. 선택한 게시글 삭제 API
    //    - 삭제를 요청할 때 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인 한 후
    //    - 선택한 게시글을 삭제하고 Client 로 성공했다는 표시 반환하기
    @DeleteMapping("/posts/{title}")
    public String deletePost(@PathVariable String title, @RequestBody PostRequestDto postRequestDto) throws Exception {
        return postService.deletePost(title, postRequestDto);
    }
}
