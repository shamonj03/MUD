package com.joe.game.io.data;

public class StaticGameMapData extends StaticData {

	/*
	 * E:ID
	 * O - Object
	 * N - Npc
	 * I - Item
	 */
	public static final String[][] map	=	{
			{	"O1",	"O1",	"O1",	"O1",	"O1",	"O1",	"O1",	"O1",	"O1",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	"N1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O2",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	"I1",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	" ",	"O1"	},
			{	"O1",	"O1",	"O1",	"O1",	"O1",	"O1",	"O1",	"O1",	"O1",	"O1"	},
			
	};

	public static String[][] getMap() {
		return map;
	}
}
