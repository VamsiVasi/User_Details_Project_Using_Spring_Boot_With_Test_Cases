package com.albanero.UserDetails_With_Test_Cases.Model;

public class Response_Model {

	private String Vowels;
	private String Special_Characters;

	public Response_Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response_Model(String vowels, String special_Characters) {
		super();
		Vowels = vowels;
		Special_Characters = special_Characters;
	}

	public String getVowels() {
		return Vowels;
	}

	public void setVowels(String vowels) {
		Vowels = vowels;
	}

	public String getSpecial_Characters() {
		return Special_Characters;
	}

	public void setSpecial_Characters(String special_Characters) {
		Special_Characters = special_Characters;
	}

	@Override
	public String toString() {
		return "Response_Model [Vowels=" + Vowels + ", Special_Characters=" + Special_Characters + "]";
	}

	

}
