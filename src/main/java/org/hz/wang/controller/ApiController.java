package org.hz.wang.controller;

import java.util.List;

import org.hz.wang.model.Student;
import org.hz.wang.util.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avaje.ebean.Ebean;
@Controller
@RequestMapping(value="/api")
public class ApiController {
	@ResponseBody
	@RequestMapping(value="/getString",method=RequestMethod.GET)
	public String getString(){
		return "wo shi String";
	}
	@ResponseBody
	@RequestMapping(value="/getStudent",method=RequestMethod.GET)
	public String getStudent(){
		Student st=Ebean.find(Student.class,1l);
		return ApiResult.single("/getStudent", st).toJson();
	}
	@ResponseBody
	@RequestMapping(value="/getStudentFetch",method=RequestMethod.GET)
	public String getStudentFetch(){
		Student st=Ebean.find(Student.class).fetch("parentList","id,name").where().idEq(1).findUnique();
		return ApiResult.single("/getStudent", st).toJson();
	}

	@ResponseBody
	@RequestMapping(value="/getStudents",method=RequestMethod.GET)
	public String getStudents(){
		List<Student> st=Ebean.find(Student.class).findList();
		return ApiResult.list("/getStudent", st).toJson();
	}
	
}
