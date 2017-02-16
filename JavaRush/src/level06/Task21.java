package level06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Task21 {
	
	/* 
	Родственные связи кошек
	
	дедушка Вася
    бабушка Мурка
    папа Котофей
    мама Василиса
    сын Мурчик
    дочь Пушинка
	
	*/

	public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Cat catGrandPa = new Cat(reader.readLine());
        Cat catGrandMa = new Cat(reader.readLine());
        Cat catFather = new Cat(reader.readLine(), catGrandPa, null);
        Cat catMother = new Cat(reader.readLine(), null, catGrandMa);
        Cat catSon = new Cat(reader.readLine(), catFather, catMother);
        Cat catDaughter = new Cat(reader.readLine(), catFather, catMother);

        System.out.println(catGrandPa);
        System.out.println(catGrandMa);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat mother;
        private Cat father;

        Cat (String name) {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString()
        {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (mother == null)
                return "Cat name is " + name + ", no mother, father is " + father.name;
            else if (father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }
}
