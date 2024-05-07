package KWU.likelion.GoldBalance.controller;

import KWU.likelion.GoldBalance.dto.request.Like;
import KWU.likelion.GoldBalance.dto.request.MakeComment;
import KWU.likelion.GoldBalance.dto.response.AddLikeCount;
import KWU.likelion.GoldBalance.dto.response.CommentList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/goldbalance/select")
public interface CommentOperations {

    // 특정 게시물의 댓글 전체 조회(모든 side에서의 댓글)
    @GetMapping("/{postId}/comment")
    ResponseEntity<CommentList> getCommentsByPostId(@PathVariable Long postId);

    // 특정 게시물의 댓글 전체 조회(특정 side에서의 댓글)
    @GetMapping("/{postId}/{selectSide}/comment")
    ResponseEntity<CommentList> getCommentsByPostIdAndSelectSide(@PathVariable Long postId,@PathVariable int selectSide);

    //부모 댓글 조회(?)
    @GetMapping("/{postId}/{selectSide}/comment/root")
    ResponseEntity<CommentList> getParentCommentsByPostIdAndSelectSide(@PathVariable Long postId,@PathVariable int selectSide);

    //자식 댓글 조회(?)
    @GetMapping("/{postId}/{selectSide}/comment/{commentId}/child")
    ResponseEntity<CommentList> getChildCommentsPostIdAndSelectSide(@PathVariable Long postId,@PathVariable int selectSide);

    //댓글 등록
    @PostMapping("/{postId}/{selectSide}/comment")
    ResponseEntity<CommentList> submitComment(@PathVariable Long postId, @PathVariable int selectSide, @RequestBody MakeComment makeCommentDto);

    // 좋아요 눌렸을 때, 좋아요 수 update
    @PostMapping("/{postId}/{selectSide}/comment/{commentId}/like")
    ResponseEntity<AddLikeCount> updateLikeCount(@PathVariable Long postId,@PathVariable Long commentId, @RequestBody Like likeDto);

}