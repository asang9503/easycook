package com.eco.easycook.controller;

import com.eco.easycook.pojo.EcCookbook;
import com.eco.easycook.pojo.EcUser;
import com.eco.easycook.service.BookCookService;
import com.eco.easycook.service.UserService;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import com.eco.easycook.util.token.SystemCon;
import com.eco.easycook.util.token.Token;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "操作菜谱接口", tags = {"菜谱接口"})
public class BookController {

    @Autowired
    BookCookService bookCookService;
    @Autowired
    UserService userService;

    @PostMapping("addBook")
    @ApiOperation(value = "添加菜谱第一步",httpMethod = "Post",notes = "需要菜谱名，和菜谱主图返回新增id" )
    ResultBean addBook(EcCookbook book,String token){
        ResultBean resultBean = userService.checkLogin(token);

        if (resultBean.getCode()== SystemCon.ROK){
            EcUser user =(EcUser) resultBean.getData();
            book.setEcUid(user.getEcUid());
            return bookCookService.addBook(book);
        }
        return resultBean;
    }


    @GetMapping("newBooks")
    @ApiOperation(value = "查询最新四条菜谱",httpMethod = "GET",notes = "展示最新的菜谱" )
    ResultBean getNewBooks(){
        return bookCookService.findNewBooks();
    }

    @GetMapping("typeBooks")
    @ApiOperation(value = "根据类型查询菜谱列表",httpMethod = "GET",notes = "展示查询类型的菜谱" )
    ResultBean getBooksByType(String tid){
        return bookCookService.findBooksByTid(tid);
    }

    @GetMapping("mycollectBooks")
    @ApiOperation(value = "查询我的收藏",httpMethod = "GET",notes = "展示我的收藏" )
    ResultBean getBooksByVid(String token){
        ResultBean resultBean = userService.checkLogin(token);

        if (resultBean.getCode()== SystemCon.ROK){
            EcUser user =(EcUser) resultBean.getData();

            return bookCookService.findBooksByVid(user.getEcUid());
        }
        return resultBean;
    }

    @GetMapping("myBooks")
    @ApiOperation(value = "查询我的收藏",httpMethod = "GET",notes = "展示我的收藏" )
    ResultBean getBooksByUid(String token){
        ResultBean resultBean = userService.checkLogin(token);

        if (resultBean.getCode()== SystemCon.ROK){
            EcUser user =(EcUser) resultBean.getData();

            return bookCookService.findBooksByuid(user.getEcUid());
        }
        return resultBean;
    }

    @GetMapping("bookDetails")
    @ApiOperation(value = "查询菜谱详情",httpMethod = "GET",notes = "从菜谱列表页根据id点击进入" )
    ResultBean bookDetails(String cid){
        return bookCookService.findBookBycid(cid);
    }


    @PostMapping("delBook")
    @ApiOperation(value = "根据菜谱id删除菜谱",httpMethod = "Post",notes = "需要菜谱名，和token" )
    ResultBean delBook(Integer cid,String token){
        ResultBean resultBean = userService.checkLogin(token);

        if (resultBean.getCode()== SystemCon.ROK){
            EcUser user =(EcUser) resultBean.getData();

            return bookCookService.delBookByCid(cid,user.getEcUid());
        }
        return resultBean;
    }

    @PostMapping("collect")
    @ApiOperation(value = "根据菜谱id添加关注",httpMethod = "Post",notes = "需要菜谱名，和token" )
    ResultBean collectBook(Integer cid,String token){
        ResultBean resultBean = userService.checkLogin(token);

        if (resultBean.getCode()== SystemCon.ROK){
            EcUser user =(EcUser) resultBean.getData();

            return bookCookService.collect(cid,user.getEcUid());
        }
        return resultBean;
    }

    @PostMapping("delcollect")
    @ApiOperation(value = "根据菜谱id删除关注",httpMethod = "Post",notes = "需要菜谱名，和token" )
    ResultBean delCollect(Integer cid,String token){
        ResultBean resultBean = userService.checkLogin(token);

        if (resultBean.getCode()== SystemCon.ROK){
            EcUser user =(EcUser) resultBean.getData();

            return bookCookService.delcollect(cid,user.getEcUid());
        }
        return resultBean;
    }





}
