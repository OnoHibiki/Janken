package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class JankenController {
    
    @GetMapping("/")
    public  String playJunken(@RequestParam(name = "hand", required = false) String userHand,Model model){
            String[] hands = {"グー","チョキ","パー"};
            Random rand = new Random();
            String aiHand = hands[rand.nextInt(3)];
            String result ;

            if(userHand == null){
                result = "手を選んでください";
            }else if(userHand.equals(aiHand)){
                result = "あいこ！";
            }else if((userHand.equals("グー")  && aiHand.equals("チョキ")) ||
                     (userHand.equals("チョキ") && aiHand.equals("パー"))  ||
                     (userHand.equals("パー")   && aiHand.equals("グー"))){
                        result = "あなたの勝ちです！！やったね！";
            }else{
                        result = "あなたの負け..." ;
            }

            model.addAttribute("userHand",userHand);
            model.addAttribute("aiHand",aiHand);
            model.addAttribute("result", result);

            return "janken"; //Janken.html　を表示

    }

}
