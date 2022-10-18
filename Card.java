import com.sun.jdi.Value;

public class Card {
      private Hauteur hauteur;
      private Coleur coleur;

    public Card(Coleur coleur, Hauteur hauteur) {
        this.hauteur = hauteur;
        this.coleur = coleur;
    }

    public Hauteur getValue() {
        return hauteur;
    }

    @Override
    public String toString() {
        return "Card{" +
                "hauteur=" + hauteur +
                ", value=" + coleur +
                '}';
    }
}
