package com.crud;

import com.crud.board.BoardService;
import com.crud.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
    @RequestMapping(value = "/")
    public String boardlist(Model model) {
        List<BoardVO> list = boardService.getBoardList();
        model.addAttribute("posts", list);
        return "posts";
    }
    @RequestMapping(value = "/posts")
    public String boardBacklist(Model model) {
        List<BoardVO> list = boardService.getBoardList();
        model.addAttribute("posts", list);
        return "redirect:/";
    }

    @RequestMapping(value="/addpostform")
    public String addPost() {
        return "addpostform";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public String addPostOK(BoardVO vo) {
        if(boardService.insertBoard(vo) == 0)
            System.out.println("데이터추가실패");
        else
            System.out.println("데이터추가성공!!");
        return "redirect:/";
    }

    @RequestMapping(value="/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO);
        return "editform";
    }

    @RequestMapping(value="/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO);
        return "view";
    }



    @RequestMapping(value = "/editform/editpost", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo) {
        if(boardService.updateBoard(vo) == 0)
            System.out.println("데이터수정실패");
        else
            System.out.println("데이터수정성공!!");
        return "redirect:/";
    }

    @RequestMapping(value="/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id) {
        System.out.println(id);
        if(boardService.deleteBoard(id)==0)
            System.out.println("데이터삭제실패");
        else
            System.out.println("데이터삭제성공!!");
        return "redirect:/";

    }
}
