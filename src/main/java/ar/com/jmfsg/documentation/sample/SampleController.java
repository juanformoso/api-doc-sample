package ar.com.jmfsg.documentation.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
