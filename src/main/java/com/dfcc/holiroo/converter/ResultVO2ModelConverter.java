package com.dfcc.holiroo.converter;

import com.dfcc.holiroo.VO.ResultVO;
import lombok.Data;
import org.springframework.ui.Model;

@Data
public class ResultVO2ModelConverter {
    public static Model convert(Model model, ResultVO resultVO){
        model.addAttribute("code", resultVO.getCode());
        model.addAttribute("msg", resultVO.getMsg());
        model.addAttribute("data", resultVO.getData());

        return model;
    }
}
