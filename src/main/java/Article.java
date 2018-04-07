package main.java;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

	@Id
	@GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getTresc() {
		return tresc;
	}
	public void setTresc(String tresc) {
		this.tresc = tresc;
	}
	private String nazwa;
	private String tresc;
	
	public Article() {}
	public Article(String nazwa, String tresc) {
		this.nazwa = nazwa;
		this.tresc = tresc;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", nazwa=" + nazwa + ", tresc=" + tresc + "]";
	}
}
