package com.rdvmedecin.liferay.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Papaya extends Tree {
	 public static void main(String[] args) {
		 new Papaya().run();
	 }
	 void run() {
		 go(new Tree(), new Papaya());
//		 go((Papaya) new Tree(), new Papaya());
	 }
	 void go(Tree t1, Papaya p1) {
		 Papaya p2 = ((Papaya)t1);
		 Tree t2 = (Tree)p1;
	 }
}
class Tree { } 
