package fuzzyBeer;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class FuzzyLogic {
	
	public static boolean ASC = true;
    public static boolean DESC = false;

	public HashMap<String, Double> evaluate(double bitterness, double alcohol, double color, double aroma) throws Exception{
		
		FIS fis = FIS.load("rules/rules.fcl");
		
		if (fis == null){
			System.err.println("Greska");
			throw new Exception("Error reading fcl file.");
		}
		
		fis.setVariable("gorcina", bitterness);
		fis.setVariable("boja", color);
		fis.setVariable("jacina", alcohol);
		fis.setVariable("aroma", aroma);
		
		fis.evaluate();
		
		HashMap<String, Double> rezultat = new HashMap<>();
		
		rezultat.put("belgianPaleAle", fis.getVariable("belgianPaleAle").defuzzify());
		rezultat.put("indianPaleAle",  fis.getVariable("indianPaleAle").defuzzify());
		//rezultat.put("witbeer",  fis.getVariable("witbeer").defuzzify());
		rezultat.put("porter",  fis.getVariable("porter").defuzzify());
		rezultat.put("stout",  fis.getVariable("stout").defuzzify());
		rezultat.put("belgianStrongAle",  fis.getVariable("belgianStrongAle").defuzzify());
		rezultat.put("bock",  fis.getVariable("bock").defuzzify());
		//rezultat.put("pilsner",  fis.getVariable("pilsner").defuzzify());
		//rezultat.put("paleLager",  fis.getVariable("paleLager").defuzzify());
		rezultat.put("darkLager",  fis.getVariable("darkLager").defuzzify());
		rezultat.put("kristalweizen",  fis.getVariable("kristalweizen").defuzzify());
		rezultat.put("heffeweizen",  fis.getVariable("heffeweizen").defuzzify());
		
		JFuzzyChart.get().chart(fis.getVariable("gorcina"), true);
		JFuzzyChart.get().chart(fis.getVariable("boja"), true);
		JFuzzyChart.get().chart(fis.getVariable("jacina"), true);
		JFuzzyChart.get().chart(fis.getVariable("aroma"), true);
		
		System.out.println("Rezultat: ");
        HashMap<String, Double> sortedMapDesc = sortByComparator(rezultat, DESC);
        printMap(sortedMapDesc);
		
        
        //for( Rule r : fis.getFunctionBlock("blockOne").getFuzzyRuleBlock("belgianPaleAleRuleBlock").getRules()) System.out.println(r);
		//for( Rule r : fis.getFunctionBlock("blockOne").getFuzzyRuleBlock("indianPaleAleRuleBlock").getRules()) System.out.println(r);
		
		return sortedMapDesc;
		
	}
	
	private static HashMap<String, Double> sortByComparator(HashMap<String, Double> unsortMap, final boolean order)
    {

        List<Entry<String, Double>> list = new LinkedList<Entry<String, Double>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Double>>()
        {
            public int compare(Entry<String, Double> o1,
                    Entry<String, Double> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        HashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Entry<String, Double> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

	private static void printMap(HashMap<String, Double> map)
    {
        for (Entry<String, Double> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }
}
