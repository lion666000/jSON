import org.json.JSONArray;
import org.json.JSONObject;

public record Item(String name, int price) {}

void main() {
    Scanner sc = new Scanner(System.in);
    Path cesta = Path.of("src/pizzeria.json");



    ArrayList<Item> list = new ArrayList<>();

    int totalAmount = 0;
    int totalPrice = 0;

    int cheapest = 900;
    int priciest = 0;

    JSONObject nejdrazsi = new JSONObject();
    JSONObject nejlevnejsi = new JSONObject();

// Načtení JSON souboru do řetězce
    String obsah = null;
    try {
        obsah = Files.readString(cesta);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
// Vytvoření JSON objektu z obsahu
    JSONObject root = new JSONObject(obsah);

// Získání pole studentů
    JSONArray pizzy = root.getJSONArray("pizzy");
    for (int i = 0; i < pizzy.length(); i++) {
        JSONObject pizza = pizzy.getJSONObject(i);
        System.out.println(pizza.getString("nazev") + " – " + pizza.getInt("cena"));

        int price = pizza.getInt("cena");

        totalPrice += price;
        totalAmount++;

        if (price > priciest) {
            priciest = price;
            nejdrazsi =  pizza;
        }
        if (price < cheapest) {
            cheapest = price;
            nejlevnejsi =  pizza;
        }

        list.add(new Item(pizza.getString("nazev"), price));
    }

    double AvaragePrice = totalPrice / totalAmount;

    System.out.println("Průměrná cena: " + AvaragePrice);

    System.out.println("Nejdražší pizza: " + nejdrazsi.getString("nazev") + " " + nejdrazsi.getInt("cena"));

    System.out.println("Nejlevnější pizza: " + nejlevnejsi.getString("nazev") + " " + nejlevnejsi.getInt("cena"));

/*

    System.out.println("Napiš dolní limit cenoveho rozmezi");
    int dolniLimit =  sc.nextInt();
    System.out.println("Napiš horní limit cenoveho rozmezi");
    int horniLimit =  sc.nextInt();

    for (int i  = 0; i < pizzy.length(); i++) {
        if ((pizzy.getJSONObject(i).getInt("cena")>=dolniLimit) && (pizzy.getJSONObject(i).getInt("cena")<=horniLimit)){
            System.out.print("Název: "+pizzy.getJSONObject(i).getString("nazev"));
            System.out.println(" cena: "+pizzy.getJSONObject(i).getInt("cena"));
        }
    }

 */
/*

    System.out.println("Zadej Ingredienci:? ");
    String ingredient = sc.next();

    for (int i = 0; i < pizzy.length(); i++) {
        JSONObject pizza = pizzy.getJSONObject(i);
        JSONArray ingredients = pizza.getJSONArray("ingredience");

        if (ingredients.toList().contains(ingredient)) {
            System.out.println(pizza.getString("nazev") + " – " + pizza.getInt("cena"));
        }
        /*
        for  (int j = 0; j < ingredients.length(); j++) {
            String ingredience = ingredients.getString(j);
            if (ingredience.equals(ingredient)){
                System.out.println(pizza.getString("nazev") + " – " + pizza.getInt("cena"));
            }
        }
        //

    }
//



/*
    list.sort(Comparator.comparingInt(Item::price));

    for  (Item item : list) {
        System.out.println(item.name() + " " + item.price());
    }

 */
/*
    JSONObject newPizza = new JSONObject();
    newPizza.put("nazev", "Negra");
    newPizza.put("cena", 5);

    JSONArray ingreds = new JSONArray();
    ingreds.put("rajčatová omáčka");
    ingreds.put("mozzarella");
    ingreds.put("šunka");
    ingreds.put("žampiony");
    ingreds.put("artyčoky");
    ingreds.put("olivy");
    newPizza.put("ingredience", ingreds);

    pizzy.put(newPizza);

    try {
        Files.writeString(cesta, root.toString(2));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

 */
/*
    IO.println("");

    int random1 = (int)(Math.random() * list.size());
    int random2 = (int)(Math.random() * list.size());

    System.out.println(list.get(random1).name() + " " + list.get(random1).price());
    System.out.println(list.get(random2).name() + " " + list.get(random2).price());

    if (list.get(random1).price() < list.get(random2).price()) {
        System.out.println(list.get(random1).name() + " je levnější");
    }
    else{
        System.out.println(list.get(random2).name() + " je levnější");
    }

 */
    /*
    JSONObject desiredPizza = pizzy.getJSONObject(0);

    System.out.println("Zadej cena:");
    int cena = sc.nextInt();
    int targetDifference = cena;
    sc.nextLine();

    for (int i = 0; i < pizzy.length(); i++) {
        JSONObject pizza = pizzy.getJSONObject(i);
        int cenaPizzy = pizza.getInt("cena");

        int priceDifference = cena - cenaPizzy;

        if (priceDifference < 0) {
            priceDifference = priceDifference * (-1);
        }

        if (priceDifference < targetDifference) {
            targetDifference = priceDifference;
            desiredPizza = pizza;
        }
    }

    System.out.println("Nejbližší pizza k zadané ceně " + cena + " : " + desiredPizza.getString("nazev") + ", " +  desiredPizza.getInt("cena"));

     */

    /*

    JSONObject desiredPizza = pizzy.getJSONObject(0);

    System.out.println("Zadej cena:");
    int cena = sc.nextInt();
    int targetDifference = cena;
    sc.nextLine();

    System.out.println("Zadej Ingredienci:? ");
    String ingredient = sc.next();

    for (int i = 0; i < pizzy.length(); i++) {
        JSONObject pizza = pizzy.getJSONObject(i);
        JSONArray ingredients = pizza.getJSONArray("ingredience");

        if (ingredients.toList().contains(ingredient)) {
            int cenaPizzy = pizza.getInt("cena");

            int priceDifference = cena - cenaPizzy;

            if (priceDifference < 0) {
                priceDifference = priceDifference * (-1);
            }

            if (priceDifference < targetDifference) {
                targetDifference = priceDifference;
                desiredPizza = pizza;
            }
        }
    }

    System.out.println("Nejbližší pizza k zadané ceně " + cena + " a s ingrediencí " + ingredient + ": " + desiredPizza.getString("nazev") + ", " +  desiredPizza.getInt("cena"));


     */

    boolean run = true;
    while (run) {
        System.out.println("Pizza Kvíz");

        ArrayList<JSONObject> lista = new ArrayList<>();

        int random1 = (int)(Math.random() * list.size());
        int random2 = (int)(Math.random() * list.size());
        int random3 = (int)(Math.random() * list.size());

        lista.add(pizzy.getJSONObject(random1));


        for (int i = 0; i < pizzy.length(); i++) {
            JSONObject pizza = pizzy.getJSONObject(i);
            JSONArray ingredients = pizza.getJSONArray("ingredience");

        }
    }





}
