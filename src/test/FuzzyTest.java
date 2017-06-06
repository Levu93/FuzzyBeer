package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import fuzzyBeer.FuzzyLogic;

public class FuzzyTest {
	
	@Test
	public void MyTest2() throws Exception {
		double bitterness = 4;
		double alcohol = 4;
		double aroma = 4;
		double color = 1;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(ipa>bock);
		assertTrue(ipa>stout);
		assertTrue(ipa>bpa);
		assertTrue(stout>bpa);
		assertTrue(stout>bock);
		assertTrue(stout>bpa);
	}
	
	@Test
	public void MyTest() throws Exception {
		double bitterness = 5;
		double alcohol = 5;
		double aroma = 5;
		double color = 1;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(ipa>bock);
		assertTrue(ipa>stout);
		assertTrue(ipa>bpa);
		assertTrue(stout>bpa);
		assertTrue(stout>bock);
	}
	
	@Test
	public void BelgianPaleAleTest1() throws Exception {
		double bitterness = 2;
		double alcohol = 2;
		double aroma = 2;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(bpa>ipa);
		assertTrue(bpa>stout);
		assertTrue(bpa>bock);
		assertTrue(ipa>stout);
	}
	
	
	@Test
	public void IPAtest1() throws Exception {
		double bitterness = 4;
		double alcohol = 3;
		double aroma = 4;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(ipa>bpa);
		assertTrue(ipa>stout);
		assertTrue(ipa>bock);
		assertTrue(stout>bock);
		assertTrue(stout>bpa);
	}
	
	@Test
	public void IPATest2() throws Exception {
		double bitterness = 4;
		double alcohol = 4;
		double aroma = 4;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(ipa>bock);
		assertTrue(ipa>stout);
		assertTrue(ipa>bpa);
		assertTrue(stout>bpa);
		assertTrue(stout>bock);
	}
	
	@Test
	public void StoutTest1() throws Exception {
		double bitterness = 5;
		double alcohol = 5;
		double aroma = 5;
		double color = 5;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
		assertTrue(stout>bock);
		assertTrue(ipa>bock);
		assertTrue(ipa>bpa);
	}
	
	@Test
	public void StoutTest2() throws Exception {
		double bitterness = 5;
		double alcohol = 5;
		double aroma = 5;
		double color = 4;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
		assertTrue(stout>bock);
		assertTrue(ipa>bock);
		assertTrue(ipa>bpa);
	}
	
	@Test
	public void StoutTest3() throws Exception {
		double bitterness = 4;
		double alcohol = 5;
		double aroma = 5;
		double color = 5;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
		assertTrue(stout>bock);
		assertTrue(ipa>bock);
		assertTrue(ipa>bpa);
	}
	
	@Test
	public void StoutTest4() throws Exception {
		double bitterness = 4;
		double alcohol = 4;
		double aroma = 5;
		double color = 4;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
		assertTrue(stout>bock);
		assertTrue(ipa>bock);
		assertTrue(ipa>bpa);
	}
	
	@Test
	public void BockTest1() throws Exception {
		double bitterness = 2;
		double alcohol = 4;
		double aroma = 4;
		double color = 3;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("indianPaleAle");
		double bpa = x.get("belgianPaleAle");
		double stout = x.get("stout");
		double bock = x.get("bock");
		assertTrue(bock>bpa);
		assertTrue(bock>stout);
		assertTrue(bock>ipa);
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
	}
}
