package test.web;

//import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

//@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/")
    public String home() {
        return "你好-POC";
    }
    
    @RequestMapping("/great")
    @ResponseBody
    public String getMessage(@RequestParam("appKey") final String appKey, @RequestParam("token") final String token) {
    	Gson gson = new Gson();
		String str = gson.toJson("appKey:" + appKey + ", token:" + token);
		System.out.println("============>str:" + str);
    	return str;
    }

    @RequestMapping(path = "/hello")
    public String hello(@RequestParam("great") final String great) {
//        log.info("调用HelloServer接口，great=" + great);
    	System.out.println("调用HelloServer接口，great=" + great);
        return great + ", IP:" + SystemUtil.getIp();
    }
}
