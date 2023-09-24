

import java.util.ArrayList;
import java.util.HashSet;

import mesCollections.ArbreLexical;

class TestArbre
{

	public static void main (String[] args)
	{
		ArbreLexical a = new ArbreLexical();
		a.add("jamais");
		a.add("trop");
		a.add("de");
		a.add("tests");
		a.add("en");
		a.add("java");
		a.add("trop");

		HashSet<String> set1 = new HashSet<String>();
		set1.add("jamais");
		set1.add("trop");
		set1.add("de");
		set1.add("tests");
		set1.add("en");
		set1.add("java");
		set1.add("trop");

		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("jamais");
		a2.add("trop");
		a2.add("de");
		a2.add("tests");
		a2.add("en");
		a2.add("java");
		a2.add("trop");

		ArrayList<String> b = new ArrayList<String>();
		b.add("efzefzg");
		b.add("juyyhtg");
		b.add("kazjdopa");
		b.add("zjdlz");
		b.add("zdzbejdzkjdoz");
		b.add("kepfern");

		ArbreLexical c = new ArbreLexical();
		c.add("zebhdbebd");
		c.add("java");
		c.add("ydzyz");

		ArbreLexical d = new ArbreLexical();
		d.add("jamais");
		d.add("de");
		d.add("en");
		d.add("java");

		ArrayList<String> d2 = new ArrayList<String>();
		d2.add("jamais");
		d2.add("de");
		d2.add("en");
		d2.add("java");

		ArbreLexical e = new ArbreLexical();
		e.add("jamais");
		e.add("trop");
		e.add("de");
		e.add("tests");
		e.add("en");
		e.add("java");


		// Affichage
		/*System.out.println("--- ToString ----------------");
		System.out.println("Size = " + a.size());
		System.out.println(a.toString());*/

		// Contains
		/*System.out.println("--- Contains ----------------");
		System.out.println(a.contains("java"));
		System.out.println(a.contains("javaazdede"));
		System.out.println(a.contains("ja"));*/

		// Remove
		/*System.out.println("--- Remove ----------------");
		a.remove("trop");
		a.remove("jav");
		System.out.println("Size = " + a.size());
		System.out.println(a.toString());*/

		// ContainsAll
		/*System.out.println("--- ContainsAll ----------------");
		System.out.println("a2.containsAll(b) : " + a2.containsAll(b));
		System.out.println("a2.containsAll(d2) : " + a2.containsAll(d2));*/

		// AddAll
		/*System.out.println("--- AddAll ----------------");
		System.out.println(a.toString());
		a.addAll(b);
		System.out.println(a.toString());*/

		// RemoveAll
		/*System.out.println("--- RemoveAll ----------------");
		System.out.println(a.toString());
		a.removeAll(d2);
		System.out.println(a.toString());*/

		// RetainAll // TODO : TEST
		/*System.out.println("--- RetainAll ----------------");
		System.out.println(a.toString());
		a.retainAll(d2);
		System.out.println(a.toString());*/

		// Hashcode
		/*System.out.println("--- Hashcode ----------------");
		System.out.println(a.hashCode());
		System.out.println(set1.hashCode());*/
	}

}
