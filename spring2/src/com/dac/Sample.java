package com.dac;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Sample {
	String id;
	String name;
	Integer no;
	long lo;
	Test test;
	
	List<String> list;
	Set<String> set;
	Map<String, String> map;
	Properties props;
	
	Sample(){
		super();
	}
	
	Sample(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	Sample(Integer no, String name){
		this.no = no;
		this.name = name;
	}
	
	Sample(String name, long lo) {
		this.name = name;
		this.lo = lo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public long getLo() {
		return lo;
	}

	public void setLo(long lo) {
		this.lo = lo;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}


}
