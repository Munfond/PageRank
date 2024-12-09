package main;

import java.util.ArrayList;
import algorithm.PageRank;
import data_reader_and_printer.*;
import graph.*;
import kol_information.KOL;
import kol_information.KOLRanking;
import data_reader_and_printer.DataPrinter;

public class Analysis {

	
	public static void runAnalysis() {
		DataReader dataRead = new DataReader();
		ArrayList<KOL> listKOL = DataProcessor.runDataProcessor(dataRead.runDataRead());
		
		Graph graph = MakeGraph.makeGraph(listKOL);
		
		
		double[] rank = PageRank.compute(100, 0.85, graph);
		
		for (int i = 0; i < listKOL.size(); ++i) {
			listKOL.get(i).setPoint(rank[i]);
		}
		
		
		KOLRanking.sortKOLsByPoint(listKOL);
		
		System.out.println("--- Results ---");
		for (int i = 0; i < listKOL.size(); ++i) {
			System.out.println("Rank: " + (i + 1) + " - KOL: " + listKOL.get(i).getKolUsername() + " - Point: " + listKOL.get(i).getPoint());
		}
		
		String filePath = "src/data/KOLRank.csv";

        // Dữ liệu mẫu
        String[] header = {"Rank", "KOL", "Point"};
        String[][] data = new String[listKOL.size()][3];        
        
		for (int i = 0; i < listKOL.size(); ++i) {
			double point = listKOL.get(i).getPoint();
			data[i][0] = String.valueOf(i + 1);
			data[i][1] = listKOL.get(i).getKolUsername();
			data[i][2] = String.valueOf(point);
		}
		
		DataPrinter.dataWriter(filePath, header, data);
        		
		
	}
}
