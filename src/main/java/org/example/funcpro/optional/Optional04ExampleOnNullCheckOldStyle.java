package org.example.funcpro.optional;

public class Optional04ExampleOnNullCheckOldStyle {

    /**
     * We need to write many null checks like belwo in old style
     *
     * @param continent
     * @return
     */
    public String getCapital(Continent continent) {
        if (continent != null) {
            Country country = continent.getCountry();
            if (country != null) {
                State state = country.getState();
                if (state != null) {
                    return state.getCapital();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Optional04ExampleOnNullCheckOldStyle obj = new Optional04ExampleOnNullCheckOldStyle();
        State state = new State("Telangana", "Hyderabad");
        Country country = new Country("India", state);
        Continent continent = new Continent("Asia", country);
        System.out.println(obj.getCapital(continent));
        // Hyderabad
    }
}
