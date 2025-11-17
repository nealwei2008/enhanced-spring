package com.yoloho.enhanced.spring.controller;

import com.yoloho.enhanced.common.support.MsgBean;
import com.yoloho.enhanced.spring.support.MvcArgument;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class CustomArgumentConverterTestController {
    public static class CommonParams implements MvcArgument {
        private int id;
        private int level;
        private String name;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getLevel() {
            return level;
        }
        public void setLevel(int level) {
            this.level = level;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public CommonParams init(HttpServletRequest request) {
            setId(NumberUtils.toInt(request.getParameter("id")));
            setName("test");
            return this;
        }
    }
	
	@RequestMapping("/first")
	public Object getMallBaseVo(String name, CommonParams commonParams) {
		MsgBean msgBean = new MsgBean();
		msgBean.put("data", commonParams);
		return msgBean.returnMsg();
	}
}
