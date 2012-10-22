package ar.com.jmfsg.documentation.sample;

import java.util.Date;

import javassist.expr.NewArray;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.jmfsg.documentation.annotation.Documentation;

@Controller
public class SampleController {

	private ModelAndView createView() {
		// This view is defined in api-doc and is used for demo purposes, you shoud obviously define your own
        return new ModelAndView("rawJsonView");
    }
	
    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    // Sample of merging some data here and some in the doc file.
    // @formatter:off
    @Documentation(data = "{" +
        "'requestMapping':'/simple'," +
        "'group':'Miscellaneous'," +
        "'description':'Simple method with no parameters'," +
        "'friendlyName':'simple'," +
        "'order':0," +
        "}")
    // @formatter:on
    public ModelAndView getSimple() {
    	ModelAndView ret = createView();
        ret.addObject("dummy-key", "dummy-value");
        return ret;
    }
    
    @RequestMapping( value = "/multipleMappings/get", method = RequestMethod.GET)
    public ModelAndView getMultipleMappings(@RequestParam(value = "param1") String param1, @RequestParam(value = "date") String date) {
    	ModelAndView ret = createView();
    	ret.addObject("param1", param1);
    	ret.addObject("date", new Date(Long.parseLong(date)).toString());
    	return ret;
    }
    
    @RequestMapping( value = "/multipleMappings/post", method = RequestMethod.POST)
    public ModelAndView postMultipleMappings(@RequestBody final JSONObject request) {
    	ModelAndView ret = createView();
    	ret.addObject("param1", request.get("param1").toString());
    	ret.addObject("date", new Date((Long)request.get("date")).toString());
    	return ret;
    }
    
    @RequestMapping( value = "/postPutMethod", method = { RequestMethod.POST, RequestMethod.PUT })
    public ModelAndView postPutMethod(@RequestBody final JSONObject request) {
    	ModelAndView ret = createView();
    	ret.addObject("param", request.get("param").toString());
    	return ret;
    }
}
