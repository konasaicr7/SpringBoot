package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ServiceI.UserServiceI;
import com.model.User;

@Controller
public class UserController {
	@Autowired
	UserServiceI use;
	
	
	@RequestMapping(value="/")
	public String prelogin()
	{
		return "login";
		
	}
	@RequestMapping(value="/register")
	public String preregister()
	{
		return "register";
		
	}
	@RequestMapping(value="/save")
	public String saveuser(@ModelAttribute User u)
	{
		int id=use.saveuser(u);
		if(id>0)
		{
			return "login";
		}
		else
		{
			return "register";
		}
	}
	@RequestMapping(value="/log")
     public String getuser(@RequestParam String username,@RequestParam String password,Model m)
{
		if(username.equals("admin") && password.equals("admin"))
		{
			List<User>userlist=use.getusers();
			m.addAttribute("data",userlist);
			return "success";
		}
		else
		{
			List<User>slist=use.getuser(username,password);
			if(slist.isEmpty())
			{
				return "login";
			}
			else
			{
				m.addAttribute("data", slist);
				return "success";
			}
		}
		
	
	
}
	@RequestMapping(value="/edit")
	public String editdata(@RequestParam int id,Model m)
	{
		User user=use.editdata(id);
		if(user!=null)
		{
			m.addAttribute("data",user);
			return"edit";
		}
		else
		{
			return "success";
		}
	}
	@RequestMapping(value="/delete")
	public String deletedata(@RequestParam int id,Model m)
	{
		int i=use.deletedata(id);
		if(id>0)
		{
			List<User>userlist=use.getusers();
			m.addAttribute("data",userlist);
			return "success";
		}
		else
		{
			return "register";
		}
	}
	@RequestMapping(value="/update")
	public String updatedata(@ModelAttribute User u,Model m)
	{
		int id=use.updatedata(u);
		if(id>0)
		{
			List<User>userlist=use.getusers();
			m.addAttribute("data",userlist);
			return "success";
		}
		else
		{
			return "register";
		}
	}
	
}
