package test.springboot.beans;

import java.util.List;

public class User {
	
		private String name ; 
		private String sex ;
		private int age ;
		private String address;
		private List<String> fav ;
		public List<String> getFav() {
			return fav;
		}
		public void setFav(List<String> fav) {
			this.fav = fav;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}


}
