package com.dajie.uploda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传控制类
 *
 * @author swinglife
 */
@Controller
public class FileUploadController {


    @RequestMapping("/filesUpload.do")
    public String filesUpload(@RequestParam("files") MultipartFile[] files,HttpServletRequest request) {
        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                //保存文件
                saveFile(file,request);
            }
        }
        return "uploadSuccess";
    }

    /**
     * 保存文件
     *
     * @param file
     * @return
     */
    private boolean saveFile(MultipartFile file,HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
     *
     * @param file
     * @return
     */
    @RequestMapping("/fileUpload.do")
    public String fileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
                        + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(filePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "uploadSuccess";
    }

    /**
     * 读取上传文件中得所有文件并返回
     *
     * @return
     */
    @RequestMapping("/list.do")
    public ModelAndView list(HttpServletRequest request) {
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        ModelAndView mav = new ModelAndView("list");
        File uploadTest = new File(filePath);
        String[] fileNames = uploadTest.list();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < fileNames.length; i++) {
            list.add(fileNames[i]);
            System.out.println(fileNames[i]);
        }
        mav.addObject("list",list);
        return mav;
    }
}