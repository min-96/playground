package org.hdcd.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.hdcd.domain.Item;
import org.hdcd.service.ItemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    //프로퍼티의 값을 읽어와 변수로 사용하겠다.
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute(new Item());
        return "item/register";
    }
    @PostMapping("/register")
    public String register(Item item,Model model)throws Exception{
        MultipartFile file = item.getPicture();
        log.info("originalName :" + file.getOriginalFilename() );
        log.info("size :" +file.getSize());
        log.info(("contentType:"+file.getContentType()));
        
        String createFileName= uploadFile(file.getOriginalFilename(),file.getBytes());
        item.setPictureUrl(createFileName);
        this.itemService.regist(item);

        model.addAttribute("msg","등록이완료됨");
        return "item/success";

    }

    @GetMapping("/modify")
    public String modifyForm(Long itemId,Model model)throws Exception{
        Item item =this.itemService.read(itemId);

        model.addAttribute(item);
        return "item/modify";

    }

    @PostMapping("/modify")
    public String modify(Item item,Model model)throws Exception{
        MultipartFile file = item.getPicture();

        if (file!=null&&file.getSize()>0){
            log.info("originalName :" + file.getOriginalFilename());
            log.info("size:"+file.getSize());
            log.info("contentType:"+file.getContentType());

            String createFileName=uploadFile(file.getOriginalFilename(),file.getBytes());

            item.setPictureUrl(createFileName);

        }

        this.itemService.modify(item);
        model.addAttribute("msg","수정이 완료되었습니다");
        return "item/success";
    }

    @GetMapping("/remove")
    public String removeForm(Long itemId,Model model)throws Exception{
        Item item = this.itemService.read(itemId);
        model.addAttribute(item);
        return "item/remove";
    }

    @PostMapping("/remove")
    public String remove(Item item,Model model)throws Exception{
        this.itemService.remove(item.getItemId());
        model.addAttribute("msg","삭제가 완료되었습니다");
        return "item/success";
    }


    //1줄 요약: 네트워크 상에서 고유성이 보장되는 id를 만들기 위한 표준 규약.
    private String uploadFile(String originalFilename, byte[] bytes)throws Exception {
        UUID uid = UUID.randomUUID();

        String createFileName = uid.toString()+"_"+originalFilename;

        File target = new File(uploadPath,createFileName);
        //파일스트립복사
        //.copy메소드 byte타입배열을 지정한후 target 파일에 복사
        FileCopyUtils.copy(bytes,target);
        return createFileName;
    }
    @ResponseBody
     @GetMapping("/display")
        public ResponseEntity<byte[]> displayFile(Long itemId)throws Exception{
        InputStream in =null;
        ResponseEntity<byte[]> entity=null;

        String fileName =itemService.getPicture(itemId);
        log.info("FILE NAME:"+fileName);

        try{
            //마지막에. 있는곳 index값 반환
            //인덱스 뒤에 있는 string 가져옴 확장자 가져옴
            String formatName=fileName.substring(fileName.lastIndexOf(".")+1);

            MediaType mType = getMediaType(formatName);
            HttpHeaders headers = new HttpHeaders();

            //separator 파일경로 나타내줌
            in=new FileInputStream(uploadPath+File.separator+fileName);

            if(mType !=null) {
                headers.setContentType(mType);
            }
                entity= new ResponseEntity<byte[]>(IOUtils.toByteArray(in),
                headers, HttpStatus.CREATED);

            }catch(Exception e) {
            e.printStackTrace();
            entity= new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);

        }finally {
            in.close();
        }
            return entity;
            
       

    }

    private MediaType getMediaType(String formatName) {
        if(formatName!=null){
            if(formatName.equals("JPG")){
                return MediaType.IMAGE_JPEG;
            }
            if(formatName.equals("GIF")){
                return MediaType.IMAGE_GIF;
            }
            if(formatName.equals("PNG")){
                return  MediaType.IMAGE_PNG;
            }
        }
        return null;
    }

}
