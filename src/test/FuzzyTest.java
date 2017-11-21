package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import fuzzyBeer.FuzzyLogic;

public class FuzzyTest {
	
	@Test
	public void BelgianPaleAleTest1() throws Exception {
		double bitterness = 2;
		double alcohol = 2;
		double aroma = 2;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
		assertTrue(bpa>ipa);
		assertTrue(bpa>stout);
		assertTrue(bpa>bock);
		assertTrue(ipa>stout);
	}
	
	@Test
	public void BelgianPaleAleTest2() throws Exception {
		double bitterness = 1;
		double alcohol = 2;
		double aroma = 1;
		double color = 1;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
		assertTrue(bpa>ipa);
		assertTrue(bpa>stout);
		assertTrue(bpa>bock);
		assertTrue(ipa>stout);
	}
		
	@Test
	public void IpaTest1() throws Exception {
		double bitterness = 4;
		double alcohol = 3;
		double aroma = 4;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
		assertTrue(ipa>bpa);
		assertTrue(ipa>stout);
		assertTrue(ipa>bock);
		assertTrue(stout>bock);
		assertTrue(stout>bpa);
	}
	
	@Test
	public void IpaTest2() throws Exception {
		double bitterness = 4;
		double alcohol = 4;
		double aroma = 4;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
		assertTrue(ipa>bock);
		assertTrue(ipa>stout);
		assertTrue(ipa>bpa);
		assertTrue(stout>bpa);
		assertTrue(stout>bock);
	}

	@Test
	public void IpaTest3() throws Exception {
		double bitterness = 4;
		double alcohol = 4;
		double aroma = 4;
		double color = 1;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
		assertTrue(ipa>bock);
		assertTrue(ipa>stout);
		assertTrue(ipa>bpa);
		assertTrue(stout>bpa);
		assertTrue(stout>bock);
		assertTrue(stout>bpa);
	}
	
	@Test
	public void IpaTest4() throws Exception {
		double bitterness = 5;
		double alcohol = 5;
		double aroma = 5;
		double color = 1;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
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
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
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
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
		assertTrue(stout>bock);
		assertTrue(ipa>bock);
		assertTrue(ipa>bpa);
	}
	
	@Test
	public void PorterTest1() throws Exception {
		double bitterness = 4;
		double alcohol = 5;
		double aroma = 5;
		double color = 5;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		assertTrue(porter>bpa);
		assertTrue(porter>ipa);
		assertTrue(porter>bock);
		assertTrue(ipa>bock);
		assertTrue(ipa>bpa);
	}
	
	@Test
	public void PorterTest2() throws Exception {
		double bitterness = 4;
		double alcohol = 4;
		double aroma = 5;
		double color = 4;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		assertTrue(porter>bpa);
		assertTrue(porter>ipa);
		assertTrue(porter>bock);
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
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double bock = x.get("Bock");
		assertTrue(bock>bpa);
		assertTrue(bock>stout);
		assertTrue(bock>ipa);
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
	}
	
	@Test
	public void BockTest2() throws Exception {
		double bitterness = 2;
		double alcohol = 5;
		double aroma = 4;
		double color = 3;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(bock>bpa);
		assertTrue(bock>stout);
		assertTrue(bock>ipa);
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
		assertTrue(bock>porter);
		assertTrue(bock>heffe);
		assertTrue(bock>kristal);
		assertTrue(bock>pilsner);
		assertTrue(bock>pale);
		assertTrue(bock>darkLager);
		assertTrue(bock>wit);
		assertTrue(strong>stout);
	}
	
	@Test
	public void HefeTest1() throws Exception {
		double bitterness = 2;
		double alcohol = 2;
		double aroma = 4;
		double color = 3;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(wit>bpa);
		assertTrue(wit>stout);
		assertTrue(wit>ipa);
		assertTrue(heffe>wit);
		assertTrue(heffe>bock);
		assertTrue(wit>stout);
		assertTrue(bock>stout);
		assertTrue(bock>ipa);
		assertTrue(wit>porter);
		assertTrue(wit>kristal);
		assertTrue(wit>pilsner);
		assertTrue(wit>pale);
		assertTrue(wit>darkLager);
		assertTrue(wit>strong);
	}
	
	@Test
	public void HefeTest2() throws Exception {
		double bitterness = 1;
		double alcohol = 1;
		double aroma = 3;
		double color = 3;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(wit>bpa);
		assertTrue(wit>stout);
		assertTrue(wit>ipa);
		assertTrue(heffe>wit);
		assertTrue(heffe>bock);
		assertTrue(wit>stout);
		assertTrue(bock>stout);
		assertTrue(bock>ipa);
		assertTrue(wit>porter);
		assertTrue(wit>kristal);
		assertTrue(heffe>pilsner);
		assertTrue(wit>pale);
		assertTrue(wit>darkLager);
		assertTrue(wit>strong);
	}
	
	@Test
	public void PilsnerTest() throws Exception {
		double bitterness = 3;
		double alcohol = 2;
		double aroma = 2;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(pale>stout);
		assertTrue(pale>ipa);
		assertTrue(pilsner>wit);
		assertTrue(pale>bock);
		assertTrue(pilsner>stout);
		assertTrue(pilsner>ipa);
		assertTrue(pilsner>bpa);
		assertTrue(pale>porter);
		assertTrue(pilsner>kristal);
		assertTrue(pilsner>heffe);
		assertTrue(pilsner>darkLager);
		assertTrue(pilsner>strong);
	}
	
	@Test
	public void WitTest() throws Exception {
		double bitterness = 2;
		double alcohol = 2;
		double aroma = 2;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(pale>stout);
		assertTrue(pale>ipa);
		assertTrue(pale>bock);
		assertTrue(pilsner>stout);
		assertTrue(pale>ipa);
		assertTrue(pale>porter);
		assertTrue(kristal>pilsner);
		assertTrue(heffe>pilsner);
		assertTrue(pilsner>darkLager);
		assertTrue(pilsner>strong);
		assertTrue(wit>pale);
		assertTrue(bpa>pale);
	}
	
	@Test
	public void KristalTest() throws Exception {
		double bitterness = 2;
		double alcohol = 2;
		double aroma = 1;
		double color = 1;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(pale>stout);
		assertTrue(pale>ipa);
		assertTrue(pale>bock);
		assertTrue(pilsner>stout);
		assertTrue(pale>ipa);
		assertTrue(pale>porter);
		assertTrue(kristal>pilsner);
		assertTrue(heffe>pilsner);
		assertTrue(pilsner>darkLager);
		assertTrue(pilsner>strong);
		assertTrue(kristal>pale);
		assertTrue(wit>pale);
		assertTrue(bpa>strong);
	}

	@Test
	public void DarkLagerTest() throws Exception {
		double bitterness = 4;
		double alcohol = 4;
		double aroma = 3;
		double color = 5;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(darkLager>ipa);
		assertTrue(darkLager>porter);
		assertTrue(darkLager>pilsner);
		assertTrue(darkLager>heffe);
		assertTrue(darkLager>strong);
		assertTrue(darkLager>pale);
		assertTrue(darkLager>wit);
		assertTrue(darkLager>kristal);
		assertTrue(darkLager>bock);
		assertTrue(darkLager>bpa);
		assertTrue(stout>ipa);
		assertTrue(porter>ipa);
		
	}

	@Test
	public void PaleLagerTest() throws Exception {
		double bitterness = 2;
		double alcohol = 2;
		double aroma = 2;
		double color = 2;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(bpa>bock);
		assertTrue(pale>stout);
		assertTrue(pale>ipa);
		assertTrue(pale>bock);
		assertTrue(pilsner>stout);
		assertTrue(pilsner>ipa);
		assertTrue(pale>porter);
		assertTrue(kristal>strong);
		assertTrue(heffe>pilsner);
		assertTrue(pilsner>darkLager);
		assertTrue(pilsner>strong);
		assertTrue(wit>strong);
	}
	
	@Test
	public void StrongTest() throws Exception {
		double bitterness = 2;
		double alcohol = 5;
		double aroma = 4;
		double color = 3;
		FuzzyLogic fl = new FuzzyLogic();
		HashMap<String, Double> x = fl.evaluate(bitterness, alcohol, color, aroma);
		double ipa = x.get("Indian Pale Ale");
		double bpa = x.get("Belgian Pale Ale");
		double stout = x.get("Stout");
		double porter = x.get("Porter");
		double bock = x.get("Bock");
		double heffe = x.get("Heffeweizen");
		double kristal = x.get("Kristalweizen");
		double pilsner = x.get("Pilsner");
		double pale = x.get("Pale lager");
		double darkLager = x.get("Dark lager");
		double strong = x.get("Belgian Strong Ale");
		double wit = x.get("Witbier");
		assertTrue(strong>bock);
		assertTrue(bock>bpa);
		assertTrue(bock>stout);
		assertTrue(bock>ipa);
		assertTrue(stout>bpa);
		assertTrue(stout>ipa);
		assertTrue(bock>porter);
		assertTrue(bock>heffe);
		assertTrue(bock>kristal);
		assertTrue(bock>pilsner);
		assertTrue(bock>pale);
		assertTrue(bock>darkLager);
		assertTrue(bock>wit);
	}
	
}
