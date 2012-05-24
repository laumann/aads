package edu.aa12;

public class Instance3 extends Graph{
	private static double[][] coords = new double[][]{
		new double[]{-3.44,0.87},
		new double[]{-3.38,-0.15},
		new double[]{-3.34,-0.68},
		new double[]{-3.25,1.34},
		new double[]{-3.16,0.72},
		new double[]{-3.09,2.10},
		new double[]{-3.04,-0.07},
		new double[]{-3.01,1.40},
		new double[]{-2.78,-1.75},
		new double[]{-2.40,-1.81},
		new double[]{-2.25,-1.69},
		new double[]{-2.22,2.34},
		new double[]{-2.15,2.17},
		new double[]{-2.09,-2.18},
		new double[]{-2.03,2.39},
		new double[]{-1.88,-2.13},
		new double[]{-1.67,2.71},
		new double[]{-1.62,-2.19},
		new double[]{-1.57,-2.66},
		new double[]{-1.52,2.40},
		new double[]{-1.37,-2.68},
		new double[]{-1.37,2.42},
		new double[]{-1.17,2.27},
		new double[]{-1.14,2.08},
		new double[]{-1.14,2.45},
		new double[]{-0.94,-2.32},
		new double[]{-0.94,2.65},
		new double[]{-0.90,2.46},
		new double[]{-0.89,2.19},
		new double[]{-0.83,-2.45},
		new double[]{-0.74,2.54},
		new double[]{-0.55,-2.26},
		new double[]{-0.50,2.05},
		new double[]{-0.45,2.59},
		new double[]{-0.35,2.39},
		new double[]{-0.13,-2.60},
		new double[]{0.27,2.24},
		new double[]{0.43,1.92},
		new double[]{0.46,-2.27},
		new double[]{0.54,2.00},
		new double[]{0.64,2.13},
		new double[]{0.70,-2.55},
		new double[]{0.70,-2.34},
		new double[]{0.70,2.33},
		new double[]{0.95,-2.22},
		new double[]{0.96,-2.02},
		new double[]{1.05,1.72},
		new double[]{1.21,-1.86},
		new double[]{1.26,1.43},
		new double[]{1.28,-2.00},
		new double[]{1.32,1.69},
		new double[]{1.33,-1.70},
		new double[]{1.41,-2.18},
		new double[]{1.54,1.56},
		new double[]{1.55,-1.98},
		new double[]{1.55,-1.58},
		new double[]{1.57,-1.82},
		new double[]{1.61,0.79},
		new double[]{1.79,0.05},
		new double[]{1.83,-0.96},
		new double[]{1.87,-1.61},
		new double[]{1.89,-0.50},
		new double[]{1.90,-0.66},
		new double[]{2.01,-1.29},
		new double[]{2.08,1.13},
		new double[]{2.10,0.60},
		new double[]{2.11,-0.21},
		new double[]{2.11,-0.73},
		new double[]{2.11,-0.91},
		new double[]{2.16,-0.53},
		new double[]{2.16,-1.22},
		new double[]{2.19,-0.02},
		new double[]{2.28,-0.91},
		new double[]{2.35,-1.13},
		new double[]{2.39,-0.18},
		new double[]{2.41,-0.37},
		new double[]{2.51,-0.71},
	};

	public Instance3(){
		super(coords);

		createEdge(0,1);
		createEdge(0,3);
		createEdge(0,4);

		createEdge(1,0);
		createEdge(1,2);
		createEdge(1,4);
		createEdge(1,6);

		createEdge(2,1);
		createEdge(2,6);
		createEdge(2,8);
		createEdge(2,10);

		createEdge(3,0);
		createEdge(3,4);
		createEdge(3,5);
		createEdge(3,7);

		createEdge(4,0);
		createEdge(4,1);
		createEdge(4,3);
		createEdge(4,6);
		createEdge(4,7);

		createEdge(5,3);
		createEdge(5,7);
		createEdge(5,11);
		createEdge(5,12);

		createEdge(6,1);
		createEdge(6,2);
		createEdge(6,4);
		createEdge(6,10);

		createEdge(7,3);
		createEdge(7,4);
		createEdge(7,5);
		createEdge(7,12);
		createEdge(7,23);

		createEdge(8,2);
		createEdge(8,9);
		createEdge(8,10);
		createEdge(8,13);

		createEdge(9,8);
		createEdge(9,10);
		createEdge(9,13);

		createEdge(10,2);
		createEdge(10,6);
		createEdge(10,8);
		createEdge(10,9);
		createEdge(10,13);
		createEdge(10,15);
		createEdge(10,17);

		createEdge(11,5);
		createEdge(11,12);
		createEdge(11,14);
		createEdge(11,16);

		createEdge(12,5);
		createEdge(12,7);
		createEdge(12,11);
		createEdge(12,14);
		createEdge(12,19);
		createEdge(12,23);

		createEdge(13,8);
		createEdge(13,9);
		createEdge(13,10);
		createEdge(13,15);
		createEdge(13,18);

		createEdge(14,11);
		createEdge(14,12);
		createEdge(14,16);
		createEdge(14,19);

		createEdge(15,10);
		createEdge(15,13);
		createEdge(15,17);
		createEdge(15,18);

		createEdge(16,11);
		createEdge(16,14);
		createEdge(16,19);
		createEdge(16,21);
		createEdge(16,24);
		createEdge(16,26);

		createEdge(17,10);
		createEdge(17,15);
		createEdge(17,18);
		createEdge(17,20);
		createEdge(17,25);

		createEdge(18,13);
		createEdge(18,15);
		createEdge(18,17);
		createEdge(18,20);

		createEdge(19,12);
		createEdge(19,14);
		createEdge(19,16);
		createEdge(19,21);
		createEdge(19,23);

		createEdge(20,17);
		createEdge(20,18);
		createEdge(20,25);
		createEdge(20,29);
		createEdge(20,35);

		createEdge(21,16);
		createEdge(21,19);
		createEdge(21,22);
		createEdge(21,23);
		createEdge(21,24);

		createEdge(22,21);
		createEdge(22,23);
		createEdge(22,24);
		createEdge(22,27);
		createEdge(22,28);

		createEdge(23,7);
		createEdge(23,12);
		createEdge(23,19);
		createEdge(23,21);
		createEdge(23,22);
		createEdge(23,28);
		createEdge(23,32);

		createEdge(24,16);
		createEdge(24,21);
		createEdge(24,22);
		createEdge(24,26);
		createEdge(24,27);

		createEdge(25,17);
		createEdge(25,20);
		createEdge(25,29);
		createEdge(25,31);

		createEdge(26,16);
		createEdge(26,24);
		createEdge(26,27);
		createEdge(26,30);
		createEdge(26,33);

		createEdge(27,22);
		createEdge(27,24);
		createEdge(27,26);
		createEdge(27,28);
		createEdge(27,30);

		createEdge(28,22);
		createEdge(28,23);
		createEdge(28,27);
		createEdge(28,30);
		createEdge(28,32);

		createEdge(29,20);
		createEdge(29,25);
		createEdge(29,31);
		createEdge(29,35);

		createEdge(30,26);
		createEdge(30,27);
		createEdge(30,28);
		createEdge(30,32);
		createEdge(30,33);
		createEdge(30,34);

		createEdge(31,25);
		createEdge(31,29);
		createEdge(31,35);
		createEdge(31,38);

		createEdge(32,23);
		createEdge(32,28);
		createEdge(32,30);
		createEdge(32,34);
		createEdge(32,36);
		createEdge(32,37);

		createEdge(33,26);
		createEdge(33,30);
		createEdge(33,34);
		createEdge(33,36);
		createEdge(33,43);

		createEdge(34,30);
		createEdge(34,32);
		createEdge(34,33);
		createEdge(34,36);

		createEdge(35,20);
		createEdge(35,29);
		createEdge(35,31);
		createEdge(35,38);
		createEdge(35,41);

		createEdge(36,32);
		createEdge(36,33);
		createEdge(36,34);
		createEdge(36,37);
		createEdge(36,39);
		createEdge(36,40);
		createEdge(36,43);

		createEdge(37,32);
		createEdge(37,36);
		createEdge(37,39);
		createEdge(37,46);
		createEdge(37,48);

		createEdge(38,31);
		createEdge(38,35);
		createEdge(38,41);
		createEdge(38,42);
		createEdge(38,45);

		createEdge(39,36);
		createEdge(39,37);
		createEdge(39,40);
		createEdge(39,46);

		createEdge(40,36);
		createEdge(40,39);
		createEdge(40,43);
		createEdge(40,46);

		createEdge(41,35);
		createEdge(41,38);
		createEdge(41,42);
		createEdge(41,44);
		createEdge(41,52);

		createEdge(42,38);
		createEdge(42,41);
		createEdge(42,44);
		createEdge(42,45);

		createEdge(43,33);
		createEdge(43,36);
		createEdge(43,40);
		createEdge(43,46);
		createEdge(43,50);

		createEdge(44,41);
		createEdge(44,42);
		createEdge(44,45);
		createEdge(44,49);
		createEdge(44,52);

		createEdge(45,38);
		createEdge(45,42);
		createEdge(45,44);
		createEdge(45,47);
		createEdge(45,49);
		createEdge(45,51);

		createEdge(46,37);
		createEdge(46,39);
		createEdge(46,40);
		createEdge(46,43);
		createEdge(46,48);
		createEdge(46,50);

		createEdge(47,45);
		createEdge(47,49);
		createEdge(47,51);

		createEdge(48,37);
		createEdge(48,46);
		createEdge(48,50);
		createEdge(48,53);
		createEdge(48,57);

		createEdge(49,44);
		createEdge(49,45);
		createEdge(49,47);
		createEdge(49,51);
		createEdge(49,52);
		createEdge(49,54);
		createEdge(49,56);

		createEdge(50,43);
		createEdge(50,46);
		createEdge(50,48);
		createEdge(50,53);

		createEdge(51,45);
		createEdge(51,47);
		createEdge(51,49);
		createEdge(51,55);
		createEdge(51,56);
		createEdge(51,59);

		createEdge(52,41);
		createEdge(52,44);
		createEdge(52,49);
		createEdge(52,54);

		createEdge(53,48);
		createEdge(53,50);
		createEdge(53,57);
		createEdge(53,64);

		createEdge(54,49);
		createEdge(54,52);
		createEdge(54,56);
		createEdge(54,60);

		createEdge(55,51);
		createEdge(55,56);
		createEdge(55,59);
		createEdge(55,60);
		createEdge(55,63);

		createEdge(56,49);
		createEdge(56,51);
		createEdge(56,54);
		createEdge(56,55);
		createEdge(56,60);

		createEdge(57,48);
		createEdge(57,53);
		createEdge(57,58);
		createEdge(57,64);
		createEdge(57,65);

		createEdge(58,57);
		createEdge(58,61);
		createEdge(58,65);
		createEdge(58,66);
		createEdge(58,71);

		createEdge(59,51);
		createEdge(59,55);
		createEdge(59,61);
		createEdge(59,62);
		createEdge(59,63);
		createEdge(59,68);
		createEdge(59,70);

		createEdge(60,54);
		createEdge(60,55);
		createEdge(60,56);
		createEdge(60,63);
		createEdge(60,70);
		createEdge(60,73);

		createEdge(61,58);
		createEdge(61,59);
		createEdge(61,62);
		createEdge(61,66);
		createEdge(61,69);

		createEdge(62,59);
		createEdge(62,61);
		createEdge(62,67);
		createEdge(62,68);
		createEdge(62,69);

		createEdge(63,55);
		createEdge(63,59);
		createEdge(63,60);
		createEdge(63,70);

		createEdge(64,53);
		createEdge(64,57);
		createEdge(64,65);

		createEdge(65,57);
		createEdge(65,58);
		createEdge(65,64);
		createEdge(65,71);
		createEdge(65,74);

		createEdge(66,58);
		createEdge(66,61);
		createEdge(66,69);
		createEdge(66,71);
		createEdge(66,74);
		createEdge(66,75);

		createEdge(67,62);
		createEdge(67,68);
		createEdge(67,69);
		createEdge(67,72);
		createEdge(67,76);

		createEdge(68,59);
		createEdge(68,62);
		createEdge(68,67);
		createEdge(68,70);
		createEdge(68,72);
		createEdge(68,73);

		createEdge(69,61);
		createEdge(69,62);
		createEdge(69,66);
		createEdge(69,67);
		createEdge(69,75);
		createEdge(69,76);

		createEdge(70,59);
		createEdge(70,60);
		createEdge(70,63);
		createEdge(70,68);
		createEdge(70,73);

		createEdge(71,58);
		createEdge(71,65);
		createEdge(71,66);
		createEdge(71,74);

		createEdge(72,67);
		createEdge(72,68);
		createEdge(72,73);
		createEdge(72,76);

		createEdge(73,60);
		createEdge(73,68);
		createEdge(73,70);
		createEdge(73,72);
		createEdge(73,76);

		createEdge(74,65);
		createEdge(74,66);
		createEdge(74,71);
		createEdge(74,75);
		createEdge(74,76);

		createEdge(75,66);
		createEdge(75,69);
		createEdge(75,74);
		createEdge(75,76);

		createEdge(76,67);
		createEdge(76,69);
		createEdge(76,72);
		createEdge(76,73);
		createEdge(76,74);
		createEdge(76,75);
	}

}
