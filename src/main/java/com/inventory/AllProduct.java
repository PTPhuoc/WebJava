package com.inventory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.MySQL.MySQLConnect;

public class AllProduct {
	public List<Product> GetAllProduct() throws Exception{
		List<Product> AllProduct = new ArrayList<Product>();
		try {
			Connection Conn = MySQLConnect.GetConnect();
			ShowAllCPU AllCPU = new ShowAllCPU();
			List<Product> CPU = AllCPU.GetAllCPU(Conn);
			AllProduct.addAll(CPU);
			ShowAllHdd AllHDD = new ShowAllHdd();
			List<Product> HDD = AllHDD.GetAllHDD(Conn);
			AllProduct.addAll(HDD);
			ShowAllHP AllHP = new ShowAllHP();
			List<Product> HP = AllHP.GetAllHP(Conn);
			AllProduct.addAll(HP);
			ShowAllKB AllKB = new ShowAllKB();
			List<Product> KB = AllKB.GetAllKB(Conn);
			AllProduct.addAll(KB);
			ShowAllM AllM = new ShowAllM();
			List<Product> M = AllM.GetAllM(Conn);
			AllProduct.addAll(M);
			ShowAllR AllR = new ShowAllR();
			List<Product> R = AllR.GetAllR(Conn);
			AllProduct.addAll(R);
			ShowAllSC AllSC = new ShowAllSC();
			List<Product> SC = AllSC.GetAllSC(Conn);
			AllProduct.addAll(SC);
			ShowAllSSD AllSSD = new ShowAllSSD();
			List<Product>  SSD = AllSSD.GetAllSSD(Conn);
			AllProduct.addAll(SSD);
			ShowAllVGA AllVGA = new ShowAllVGA();
			List<Product> VGA = AllVGA.GetAllVGA(Conn);
			AllProduct.addAll(VGA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.shuffle(AllProduct);
		return AllProduct;
	}
}
