public class TestPileTableau
{

    public static void main(String[] args)
    {
	/*Pile<String> strings = new PileTableau<String>("pile strings");
	strings.empile("azertyuiop");
	strings.empile("qsdfghjklm");
	strings.empile("wxcvbn");
	System.out.println(strings.toString());

	Pile<String> strings2 = new PileTableau<String>("pile strings2");
	strings2.empile("a");
	strings2.empile("b");
	strings2.empile("c");
	System.out.println(strings2.toString());*/

	/*strings.deplacerElementVers(strings2);
	System.out.println(strings.toString());
	System.out.println(strings2.toString());*/

	/*Pile<Integer> integers = new PileTableau<Integer>("pile integers");
	integers.empile(4);
	integers.empile(5455477);
	integers.empile(-127);
	System.out.println(integers.toString());*/

	/*Pile<Comparable> objects = new PileTableau<Comparable>("pile objects");
	objects.empile(new String("test"));
	objects.empile(new Integer(45));
	objects.empile(new Character('f'));
	objects.empile(new Rationnel(5, 3, 4));
	System.out.println(objects.toString());*/

	Pile objects2 = new PileTableauComp("pile objects2");
	objects2.empile(new String("test"));
	objects2.empile(new Integer(45));
	objects2.empile(new Character('f'));
	objects2.empile(new Rationnel(5, 3, 4));
	//objects2.empile(new StringBuilder()); // erreur : pas comparable
	System.out.println(objects2.toString());

	objects2.trier();
	System.out.println(objects2.toString());

	// --------------------


    }

}