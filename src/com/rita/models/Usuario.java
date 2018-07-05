package com.rita.models;

public class Usuario {
	private String nombre;
	private String email;
	private String password;
	private int edad;
	private String sexo;
	
	public Usuario(String nombre, String email, String password) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.edad = 0;
		this.sexo = "";
	}

	public Usuario(String nombre, String email, String password, int edad, String sexo) {
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.edad = edad;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
