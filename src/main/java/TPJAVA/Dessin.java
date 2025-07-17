package TPJAVA;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Dessin {
    //   Je met les figures dans un linked hashset car chaque figure dans le hashSet sera unique (pas de doublon) et apparaitront dans l'ordre
    private final Collection<Figure> figures;

    public Dessin(){
        this.figures = new LinkedHashSet<>();
    }

    public Dessin(Collection<Figure> figures) {
        this();
        this.figures.addAll(figures);
    }

    public boolean add(Figure fig) {
        return this.figures.add(fig);
    }

    public Collection<Figure> getFigures() {
        return this.figures;
    }
}
