package tw.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/myMainTest")
	public String myMainTest() {
		return "test/myMainJsp";
	}
	
	@GetMapping("/myMainPar")
	public String myMainPar(Model m) {
		m.addAttribute("par1", "Testing");
		
		ArrayList<Object> lists = new ArrayList<>();
		lists.add("A");
		lists.add("B");
		lists.add("你好");
		
		ArrayList lists2 = new ArrayList<>();

		lists2.add(new MyBean(01, "StrA"));
		lists2.add(new MyBean(02, "StrB"));
		lists2.add(new MyBean(03, "StrC"));
		
		HashMap map1 = new HashMap<>();
		map1.put("key1", "Str01");
		map1.put("key2", 111);
		map1.put(22L, lists);
		
		MyBean bean = new MyBean(123, "StrB");
		
		
		m.addAttribute("par1", "Testing");
		m.addAttribute("par2", lists);
		m.addAttribute("par3", map1);
		m.addAttribute("par4", bean);
		m.addAttribute("par5", lists2);
		
		
		return "test/myMainParJ";
	}
	
}
